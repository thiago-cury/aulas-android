package thiagocury.eti.br.exbancosqliteprodutoapi19;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    private EditText etCodigo;
    private EditText etNome;
    private EditText etValorCusto;
    private EditText etQuantidade;
    private Button btnAdicionar;

    private Produto p;

    //Banco
    private ProdutoDAO pDAO; //instância responsável pela persistência dos dados

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        etCodigo = (EditText) findViewById(R.id.et_codigo);
        etNome = (EditText) findViewById(R.id.et_nome);
        etValorCusto = (EditText) findViewById(R.id.et_valor_custo);
        etQuantidade = (EditText) findViewById(R.id.et_quantidade);
        btnAdicionar = (Button) findViewById(R.id.btn_adicionar);

        //Instanciando e abrindo o banco
        pDAO = new ProdutoDAO(this);
        pDAO.abrirBanco();

        //Adicionar
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p = new Produto();
                p.setIdProduto(Long.parseLong(etCodigo.getText().toString()));
                p.setNome(etNome.getText().toString());
                p.setValorCusto(Double.parseDouble(etValorCusto.getText().toString()));
                p.setQuantidade(Long.parseLong(etQuantidade.getText().toString()));

                //Enviando para o método cadastrar
                pDAO.inserir(p);

                Toast.makeText(
                        getBaseContext(),
                        "Produto cadastrado com sucesso!",
                        Toast.LENGTH_LONG).show();

                limpar();
            }
        });
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //Toda vez que a Activity receber o foco, ativamos a conexão com o BD
        pDAO.abrirBanco();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //Toda vez que a Activity perder o foco, encerramos a conexão com o BD
        pDAO.fecharBanco();
    }

    private void limpar(){
        etCodigo.setText(null);
        etNome.setText(null);
        etValorCusto.setText(null);
        etQuantidade.setText(null);
    }
}