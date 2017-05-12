package thiagocury.eti.br.exconsumindojsonnetflixrouletteapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private EditText etDiretor;
    private Button btnPesquisar;
    private ListView lvFilmes;
    private ProgressBar progress;

    private FilmeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDiretor = (EditText) findViewById(R.id.et_diretor);
        btnPesquisar = (Button) findViewById(R.id.btn_pesquisar);
        lvFilmes = (ListView) findViewById(R.id.lv_filmes);
        progress = (ProgressBar) findViewById(R.id.progress);

        progress.setVisibility(View.GONE);

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.setVisibility(View.VISIBLE);
                getFilmes(etDiretor.getText().toString());
            }
        });
    }

    public void getFilmes(String diretor) {
        RequestParams params = new RequestParams();
        params.add("director", diretor);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://netflixroulette.net/api/api.php?", params, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                progress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getBaseContext(), "Problema na conexao!"+statusCode, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                Filme[] fs = gson.fromJson(responseString, Filme[].class);

                ArrayList<Filme> list = new ArrayList<>(Arrays.asList(fs));
                adapter = new FilmeAdapter(MainActivity.this, list);
                lvFilmes.setAdapter(adapter);
                progress.setVisibility(View.GONE);
            }
        });
    }
}