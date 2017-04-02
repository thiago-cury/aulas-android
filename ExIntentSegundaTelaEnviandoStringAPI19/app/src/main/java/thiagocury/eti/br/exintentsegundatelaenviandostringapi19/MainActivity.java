package thiagocury.eti.br.exintentsegundatelaenviandostringapi19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                /* Criando variáveis locais para receber e enviar os valore
                   para a próxima tela através do método putExtra() */
                String login = etLogin.getText().toString();
                String senha = etSenha.getText().toString();

                Intent it = new Intent(MainActivity.this, Tela2.class);

                //Passando os valores
                it.putExtra("login", login);
                it.putExtra("senha", senha);

                startActivity(it);

                //Opcional: encerrar a activity
                //finish();
            }
        });
    }
}