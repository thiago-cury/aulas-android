package thiagocury.eti.br.exconsumindojsonestaticoclienteapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //JSON ESTÁTICO - Exemplo recebendo um JSON com um cliente de forma estática.

        /* Exemplo de um JSON Cliente estático sem as contra-barras. Fica mais visível para o entendimento.
           {
           cliente:{"id":"1","nome":"Thiago Cury", "RG": "1234567891", "email": "thiagocury@gmail.com"}
             }
        */

        //Exemplo JSON Cliente com as aspas sendo escapadas através da \ contra barra.
        String jsonCliente = "{cliente:{\"id\":\"1\",\"nome\":\"Thiago Cury\", \"RG\": \"1234567891\", \"email\": \"thiagocury@gmail.com\"}}";

        try {
            Cliente cli = new Cliente();
            JSONObject jsonObject = new JSONObject(jsonCliente);
            JSONObject cliObject = jsonObject.getJSONObject("cliente");

            cli.setId(cliObject.getInt("id"));
            cli.setNome(cliObject.getString("nome"));
            cli.setRG(cliObject.getString("RG"));
            cli.setEmail(cliObject.getString("email"));

            Toast.makeText(getBaseContext(),"Cliente: "+cli.toString(), Toast.LENGTH_LONG).show();

        }catch (JSONException e){

            Toast.makeText(getBaseContext(),"Erro! "+e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
}