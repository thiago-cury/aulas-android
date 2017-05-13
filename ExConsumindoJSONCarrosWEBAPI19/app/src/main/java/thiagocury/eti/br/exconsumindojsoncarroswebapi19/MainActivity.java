package thiagocury.eti.br.exconsumindojsoncarroswebapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCarros();

    }

    public void getCarros(){
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://thiagocury.eti.br/testes/json/carros.json", params, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                //Progress
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getBaseContext(), "Problema na conexao!"+statusCode, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Gson gson = new Gson();
                Carro[] c = gson.fromJson(responseString, Carro[].class);
                ArrayList<Carro> carros = new ArrayList<>(Arrays.asList(c));

                new MaterialDialog.Builder(MainActivity.this)
                        .title("Dados recebidos")
                        .content(carros.toString())
                        .positiveText("OK")
                        .show();

            }
        });
    }
}
