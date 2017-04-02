package thiagocury.eti.br.exintentsegundatelaenviandostringapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    //Widgets
    private TextView tvBoasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //Referencias
        tvBoasVindas = (TextView) findViewById(R.id.tv_boas_vindas);

        //Recebendo os valores passados como String
        String login = getIntent().getStringExtra("login");
        String senha = getIntent().getStringExtra("senha");

        //Testando se o usuario digitou valores.
        if(!login.isEmpty() && !senha.isEmpty()) {

            //Mostrando no TextView
            tvBoasVindas.setText("Olá "+login+", seja bem vindo!\nSua senha é: "+senha);

            //Mostrando na Toast
            Toast.makeText(getBaseContext(),
                    "Olá "+login+", seja bem vindo!\nSua senha é: "+senha,
                    Toast.LENGTH_LONG).show();
        } else {

            tvBoasVindas.setText(null);

            Toast.makeText(getBaseContext(),
                    "Erro ao receber informações!",
                    Toast.LENGTH_LONG).show();
        }

    }
}