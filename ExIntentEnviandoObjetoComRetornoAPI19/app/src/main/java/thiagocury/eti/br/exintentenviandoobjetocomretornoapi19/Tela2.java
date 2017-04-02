package thiagocury.eti.br.exintentenviandoobjetocomretornoapi19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import thiagocury.eti.br.exintentenviandoobjetocomretornoapi19.model.Usuario;

public class Tela2 extends AppCompatActivity {

    //Widget
    private EditText etFraseSecreta;
    private Button btnConfirmar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //Referencias
        etFraseSecreta = (EditText) findViewById(R.id.et_frase_secreta);
        btnConfirmar = (Button) findViewById(R.id.btn_confirmar);
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);

        //Recebendo os valores passados como String
        Usuario u = (Usuario) getIntent().getSerializableExtra("usuario");

        //Testando se o usuario digitou valores.
        if(!u.getLogin().isEmpty() &&
           !u.getSenha().isEmpty()) {

            //Mostrando na Toast
            Toast.makeText(getBaseContext(),
                    "Olá "+u.getLogin()+", seja bem vindo!\nSua senha é: "+u.getSenha(),
                    Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getBaseContext(),
                    "Erro ao receber informações!",
                    Toast.LENGTH_LONG).show();
        }

        //onClick do botão Confirmar
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent();
                it.putExtra("frase",etFraseSecreta.getText().toString());
                setResult(RESULT_OK,it);
                finish();
            }
        });

        //onClick do botão Cancelar
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}