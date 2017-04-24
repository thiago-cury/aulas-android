package thiagocury.eti.br.exentradadedadosedittextcomexpressoesregularesapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etCodigo;
    private EditText etNome;
    private EditText etCPF;
    private EditText etSalario;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referências
        etCodigo = (EditText) findViewById(R.id.et_codigo);
        etNome = (EditText) findViewById(R.id.et_nome);
        etCPF = (EditText) findViewById(R.id.et_cpf);
        etSalario = (EditText) findViewById(R.id.et_salario);
        btnOK = (Button) findViewById(R.id.btn_ok);

        //Evento onClick do botão OK para receber os dados do cliente.
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validação simples. Se todos estiverem certo cadastra, se um estiver errado não vai cadastrar.
                if(Validacao.validarCodigo(etCodigo.getText().toString()) &&
                   Validacao.validarNome(etNome.getText().toString()) &&
                   Validacao.validarCPF(etCPF.getText().toString())&&
                   Validacao.validarSalario(etSalario.getText().toString())) {

                    //Instanciando objeto cli do tipo Cliente.
                    Cliente cli = new Cliente();
                    cli.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
                    cli.setNome(etNome.getText().toString());
                    cli.setCPF(Long.parseLong(etCPF.getText().toString()));
                    cli.setSalario(Double.parseDouble(etSalario.getText().toString()));
                    //Enviando retorno para o usuário do App.
                    Toast.makeText(
                            getBaseContext(),
                            "Cliente cadastrado!\n" + cli.toString(),
                            Toast.LENGTH_LONG).show();
                } else {
                    //Enviando retorno de erro para o usuário.
                    Toast.makeText(
                            getBaseContext(),
                            "Dados inválidos!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}