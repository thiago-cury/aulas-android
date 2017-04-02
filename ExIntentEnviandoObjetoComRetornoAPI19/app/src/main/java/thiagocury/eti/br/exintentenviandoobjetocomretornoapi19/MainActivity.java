package thiagocury.eti.br.exintentenviandoobjetocomretornoapi19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import thiagocury.eti.br.exintentenviandoobjetocomretornoapi19.model.Usuario;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etLogin;
    private EditText etSenha;
    private Button btnOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etLogin = (EditText) findViewById(R.id.et_login);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btnOK = (Button) findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Instanciando objeto que será enviado para a Tela 2 */
                Usuario u = new Usuario();

                /* Recebendo os valores no objeto para enviar para
                   a próxima tela através do método putExtra() */
                u.setLogin(etLogin.getText().toString());
                u.setSenha(etSenha.getText().toString());

                Intent it = new Intent(MainActivity.this, Tela2.class);

                //Passando os valores
                it.putExtra("usuario", u);

                /* Indicando um id específico para a Activity que vai ser aberta.
                   Pode ser qualquer número inteiro para identificar, nesse caso utilizamos o número 10. */
                startActivityForResult(it,10);
            }
        });

    }//onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /* Testando qual Activity retornou, nesse caso a Activity núm. 10 */
        if(requestCode == 10){

            /* Testando se o usuário clicou no botão "Confirmar" ou "Cancelar". */
            if(resultCode == RESULT_OK){

                String frase = data.getStringExtra("frase");

                Toast.makeText(getBaseContext(),
                        "Sua frase secreta é: "+frase,
                        Toast.LENGTH_LONG).show();

            }else if(resultCode == RESULT_CANCELED){

                Toast.makeText(getBaseContext(),
                        "Usuário cancelou!",
                        Toast.LENGTH_LONG).show();

            }
        }
    }
}