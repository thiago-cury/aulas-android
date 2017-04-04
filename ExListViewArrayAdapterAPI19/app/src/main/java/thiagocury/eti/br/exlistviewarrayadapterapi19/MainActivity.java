package thiagocury.eti.br.exlistviewarrayadapterapi19;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private Button btnOK;
    private ListView lvContato;

    //ArrayList + Adapters
    private ArrayList<String> contatos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etNome = (EditText) findViewById(R.id.et_nome);
        btnOK = (Button) findViewById(R.id.btn_ok);
        lvContato = (ListView) findViewById(R.id.lv_contato);

        contatos = new ArrayList<>(); //ArrayList vazio!

        //Instanciando o ArrayAdapter e adicionando o ArrayList de contatos
        adapter = new ArrayAdapter<String>(
                                MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                contatos);

        //Setando o adapter na ListView de contatos
        lvContato.setAdapter(adapter);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!etNome.getText().toString().isEmpty()) {

                    //Adicionando novo contato no ArrayList
                    contatos.add(etNome.getText().toString());

                    //Notificando o Adapter que houve uma mudança no ArrayList
                    adapter.notifyDataSetChanged();

                    etNome.setText(null); //limpando o campo

                    Toast.makeText(
                            getBaseContext(),
                            "Contato cadastrado com sucesso!",
                            Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(
                            getBaseContext(),
                            "Digite um nome por favor!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        lvContato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String contato = lvContato.getItemAtPosition(position).toString();

                Toast.makeText(
                        getBaseContext(),
                        "Nome escolhido: "+contato,
                        Toast.LENGTH_LONG).show();
            }
        });

        lvContato.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Escolha");
                msg.setMessage("Você tem certeza que deseja remover?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Removendo a posicao do ArrayList
                        contatos.remove(position);

                        //Notificando o Adapter que houve uma alteracao no ArrayList
                        adapter.notifyDataSetChanged();

                        Toast.makeText(
                                getBaseContext(),
                                "Contato removido com sucesso!",
                                Toast.LENGTH_LONG).show();
                    }
                });

                msg.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(
                                getBaseContext(),
                                "OK!",
                                Toast.LENGTH_LONG).show();
                    }
                });
                msg.show();

                return true;
            }
        });
    }
}