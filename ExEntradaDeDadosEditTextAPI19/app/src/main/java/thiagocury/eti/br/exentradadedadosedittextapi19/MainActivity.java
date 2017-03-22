package thiagocury.eti.br.exentradadedadosedittextapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referências
        etNome = (EditText) findViewById(R.id.et_nome);
        btnOK = (Button) findViewById(R.id.btn_ok);

        //Evento onClick do botão OK para receber o nome
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instanciando objeto cli do tipo Cliente.
                Cliente cli = new Cliente();

                //Recebendo o nome como String.
                cli.setNome(etNome.getText().toString());

                //Enviando retorno para o usuário do App.
                Toast.makeText(
                        getBaseContext(),
                        "Cliente cadastrado!\n"+cli.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
