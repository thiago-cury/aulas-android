package thiagocury.eti.br.exintentsegundatelaenviandoobjetoapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import thiagocury.eti.br.exintentsegundatelaenviandoobjetoapi19.model.Usuario;

public class Tela2 extends AppCompatActivity {

    //Widget
    private TextView tvBoasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //Referencias
        tvBoasVindas = (TextView) findViewById(R.id.tv_boas_vindas);

        //Recebendo os valores passados como String
        Usuario u = (Usuario) getIntent().getSerializableExtra("usuario");

        //Testando se o usuario digitou valores.
        if(!u.getLogin().isEmpty() &&
           !u.getSenha().isEmpty()) {

            //Mostrando no TextView
            tvBoasVindas.setText("Olá "+u.getLogin()+", seja bem vindo!\nSua senha é: "+u.getSenha());

            //Mostrando na Toast
            Toast.makeText(getBaseContext(),
                    "Olá "+u.getLogin()+", seja bem vindo!\nSua senha é: "+u.getSenha(),
                    Toast.LENGTH_LONG).show();
        } else {

            tvBoasVindas.setText("");

            Toast.makeText(getBaseContext(),
                    "Erro ao receber informações!",
                    Toast.LENGTH_LONG).show();
        }
    }
}