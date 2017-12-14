package thiagocury.eti.br.exrecyclerviewclienteonitemclickonitemlongclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private EditText etRenda;
    private Spinner spSexo;
    private Button btnOK;
    private RecyclerView rvClientes;

    private ClienteAdapter adapter;
    private ArrayList<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etNome = (EditText) findViewById(R.id.et_nome);
        etRenda = (EditText) findViewById(R.id.et_renda);
        spSexo = (Spinner) findViewById(R.id.sp_sexo);
        btnOK = (Button) findViewById(R.id.btn_ok);
        rvClientes = (RecyclerView) findViewById(R.id.recycler_view_clientes);

        //Instanciando ArrayList e setando no Adapter
        clientes = new ArrayList<>();
        adapter = new ClienteAdapter(MainActivity.this, clientes);
        rvClientes.setAdapter(adapter);
        rvClientes.setHasFixedSize(true);
        rvClientes.setLayoutManager(new LinearLayoutManager(this));

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instanciando um novo objeto Cliente
                Cliente c = new Cliente();

                //Entrada de dados
                c.setNome(etNome.getText().toString());
                c.setRenda(Double.parseDouble(etRenda.getText().toString()));
                c.setSexo(spSexo.getSelectedItem().toString());

                //Adicionando o novo cliente no ArrayList
                clientes.add(c);

                //Notificando o Adapter a mudança no ArrayList
                adapter.notifyDataSetChanged();
            }
        });

        //Setando o onItemClick e onItemLongClick
        adapter.setOnItemClickListener(new ClienteAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Cliente c = clientes.get(position);

                Toast.makeText(
                        getBaseContext(),
                        "Cliente escolhido: "+c.toString(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {

                Cliente c = clientes.get(position);

                Toast.makeText(
                        getBaseContext(),
                        "Clique longo para escolher cliente: "+c.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}