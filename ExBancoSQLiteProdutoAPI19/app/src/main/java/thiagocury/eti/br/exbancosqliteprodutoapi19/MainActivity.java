package thiagocury.eti.br.exbancosqliteprodutoapi19;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Banco
    private ProdutoDAO pDAO; //instância responsável pela persistência dos dados

    private ArrayList<Produto> prodAux; //Lista de contatos cadastrados no BD
    private ProdutoAdapter adapter; //adapter para receber os dados

    //Componentes visuais
    private ListView lvProdutos;

    //Guarda a posição selecionada
    private int posSelec = -1;

    private MenuItem menuEditar;
    private MenuItem menuRemover;
    private static boolean HIDE_MENU = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvProdutos = (ListView) findViewById(R.id.lv_produtos);

        pDAO = new ProdutoDAO(this);
        pDAO.abrirBanco();
        prodAux = pDAO.consultar();
        adapter = new ProdutoAdapter(this, prodAux);
        lvProdutos.setAdapter(adapter);
        //Notificando o adapter para atualização dos dados na tela
        adapter.notifyDataSetChanged();

        if(!pDAO.consultar().isEmpty()){
            HIDE_MENU = false;
        } else {
            HIDE_MENU = true;
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, TelaCadastro.class);
                startActivity(it);
            }
        });

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //posição selecionada pelo usuário
                posSelec = position;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menuEditar = menu.findItem(R.id.menu_editar);
        menuRemover = menu.findItem(R.id.menu_remover);

        if (HIDE_MENU) {
            menuEditar.setVisible(false);
            menuRemover.setVisible(false);
        } else {
            menuEditar.setVisible(true);
            menuRemover.setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_editar:

                if(posSelec==-1) {

                    Toast.makeText(
                            getBaseContext(),
                            "Selecione um produto para editar!",
                            Toast.LENGTH_LONG).show();

                }else {

                    final MaterialDialog.Builder dialog = new MaterialDialog.Builder(MainActivity.this);
                    View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_editar, null);
                    final EditText etCodigo = (EditText) v.findViewById(R.id.dialog_editar_et_codigo);
                    final EditText etNome = (EditText) v.findViewById(R.id.dialog_editar_et_nome);
                    final EditText etValorCusto = (EditText) v.findViewById(R.id.dialog_editar_et_valor_custo);
                    final EditText etQuantidade = (EditText) v.findViewById(R.id.dialog_editar_et_quantidade);

                    final Produto p = prodAux.get(posSelec);
                    etCodigo.setText(String.valueOf(p.getIdProduto()));
                    etNome.setText(p.getNome());
                    etValorCusto.setText(String.valueOf(p.getValorCusto()));
                    etQuantidade.setText(String.valueOf(p.getQuantidade()));

                    dialog.limitIconToDefaultSize()
                            .title("Editar Produto")
                            .positiveText("Alterar")
                            .negativeText("Cancelar")
                            .customView(v, false)
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                    p.setIdProduto(Long.parseLong(etCodigo.getText().toString()));
                                    p.setNome(etNome.getText().toString());
                                    p.setValorCusto(Double.parseDouble(etValorCusto.getText().toString()));
                                    p.setQuantidade(Long.parseLong(etQuantidade.getText().toString()));

                                    pDAO.alterar(p);
                                    adapter.notifyDataSetChanged();

                                    Toast.makeText(
                                            getBaseContext(),
                                            "Produto alterado com sucesso!",
                                            Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();
                }

                break;

            case R.id.menu_remover:

                if(posSelec==-1) {

                    Toast.makeText(
                            getBaseContext(),
                            "Selecione um produto para excluir!",
                            Toast.LENGTH_LONG).show();

                }else{

                    //Resgatando o produto selecionado pelo usuario
                    Produto p = prodAux.get(posSelec);
                    //Removendo do Banco
                    pDAO.excluir(p);
                    //Removendo do ArrayList
                    prodAux.remove(p);

                    Toast.makeText(
                            getBaseContext(),
                            "Produto excluído com sucesso!",
                            Toast.LENGTH_LONG).show();

                    //Notificando o adapter
                    adapter.notifyDataSetChanged();

                    //Escondendo o menu novamente
                    if (prodAux.isEmpty()) {
                        menuEditar.setVisible(false);
                        menuRemover.setVisible(false);
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
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
}