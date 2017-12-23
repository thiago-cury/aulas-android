package thiagocury.eti.br.exconsumindojsoncarroswebapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    //Widgets
    private RecyclerView rvCarros;
    private ProgressBar progress;

    //Adapter + ArrayList
    private ArrayList<Carro> carros;
    private CarroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        rvCarros = findViewById(R.id.ma_rv_carros);
        progress = findViewById(R.id.ma_progress);

        progress.setVisibility(View.INVISIBLE);

        //Método para buscar os carros
        getCarros();

    }

    public void getCarros(){
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://thiagocury.eti.br/testes/json/carros.json", params, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();

                progress.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getBaseContext(), getResources().getText(R.string.toast_erro)+" "+statusCode, Toast.LENGTH_LONG).show();
                progress.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Gson gson = new Gson();
                Carro[] c = gson.fromJson(responseString, Carro[].class);

                carros = new ArrayList<>(Arrays.asList(c));
                adapter = new CarroAdapter(MainActivity.this, carros);
                rvCarros.setAdapter(adapter);
                rvCarros.setHasFixedSize(true);
                rvCarros.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                Toast.makeText(
                        getBaseContext(),
                        getResources().getText(R.string.toast_sucesso),
                        Toast.LENGTH_LONG).show();

                progress.setVisibility(View.INVISIBLE);

            }
        });
    }
}
