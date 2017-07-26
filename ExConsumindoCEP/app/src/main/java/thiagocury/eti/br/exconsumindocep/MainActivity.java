package thiagocury.eti.br.exconsumindocep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etCEP;
    private Button btnBuscar;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ref.
        etCEP = (EditText) findViewById(R.id.et_cep);
        btnBuscar = (Button) findViewById(R.id.btn_buscar);
        progress = (ProgressBar) findViewById(R.id.progress);

        progress.setVisibility(View.INVISIBLE);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCEP(etCEP.getText().toString());
                etCEP.setText(null);
            }
        });
    }

    public void getCEP(String cep) {
        RequestParams params = new RequestParams();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://viacep.com.br/ws/" + cep + "/json/", params, new TextHttpResponseHandler() {

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

                try {
                    JSONObject obj = new JSONObject(responseString);

                    String retorno = "";

                    if (!obj.has("erro")) {
                        retorno += "\n" + obj.getString("cep");
                        retorno += "\n" + obj.getString("logradouro");
                        retorno += "\n" + obj.getString("complemento");
                        retorno += "\n" + obj.getString("bairro");
                        retorno += "\n" + obj.getString("localidade");
                        retorno += "\n" + obj.getString("uf");
                        retorno += "\n" + obj.getString("ibge");
                        retorno += "\n" + obj.getString("gia");

                        Toast.makeText(getBaseContext(),"Dados retornados: "+retorno, Toast.LENGTH_LONG).show();
                    }
                    progress.setVisibility(View.INVISIBLE);
                }catch(JSONException e){

                }
            }
        });
    }
}