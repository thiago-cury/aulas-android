package thiagocury.eti.br.exconsumindojsonestaticoclientecomgsonapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

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

        /* Lembrando que para o GSON funcionar
           precisamos sincronizar no gradle a lib:
           compile 'com.google.code.gson:gson:2.8.0' */

        Gson gson = new Gson();
        ApiCliente cli = gson.fromJson(jsonCliente, ApiCliente.class);

        Toast.makeText(getBaseContext(),"\nID: "+cli.getCliente().getId()+
                                        "\nNome: "+cli.getCliente().getNome()+
                                        "\nRG: "+cli.getCliente().getRG()+
                                        "\nEmail: "+cli.getCliente().getEmail()
                                        , Toast.LENGTH_LONG).show();
    }
}