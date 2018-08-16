package thiagocury.eti.br.exentradadedadosedittextmask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import thiagocury.eti.br.exentradadedadosedittextmask.helper.MaskEditUtil;
import thiagocury.eti.br.exentradadedadosedittextmask.model.Cliente;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private EditText etCPF;
    private EditText etTelefone;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        etNome = findViewById(R.id.ma_et_nome);
        etCPF = findViewById(R.id.ma_et_cpf);
        etTelefone = findViewById(R.id.ma_et_telefone);
        btCadastrar = findViewById(R.id.ma_bt_cadastrar);

        //Adicionando as máscaras
        etCPF.addTextChangedListener(MaskEditUtil.mask(etCPF, MaskEditUtil.FORMAT_CPF));
        etTelefone.addTextChangedListener(MaskEditUtil.mask(etTelefone, MaskEditUtil.FORMAT_TELEFONE));

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cliente c = new Cliente();

                c.setNome(etNome.getText().toString());
                c.setCPF(etCPF.getText().toString());
                c.setTelefone(etTelefone.getText().toString());

                limpar();

                toast("Cliente cadastrado com sucesso!"+c.toString());
            }
        });
    }

    private void limpar(){
        etNome.setText("");
        etCPF.setText("");
        etTelefone.setText("");
        etNome.requestFocus();
    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg, Toast.LENGTH_LONG).show();
    }
}