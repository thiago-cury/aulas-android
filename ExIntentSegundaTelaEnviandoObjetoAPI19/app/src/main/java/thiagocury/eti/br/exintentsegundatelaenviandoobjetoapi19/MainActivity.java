package thiagocury.eti.br.exintentsegundatelaenviandoobjetoapi19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thiagocury.eti.br.exintentsegundatelaenviandoobjetoapi19.model.Usuario;

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

                startActivity(it);

                //Opcional: encerrar a activity
                //finish();
            }
        });
    }
}