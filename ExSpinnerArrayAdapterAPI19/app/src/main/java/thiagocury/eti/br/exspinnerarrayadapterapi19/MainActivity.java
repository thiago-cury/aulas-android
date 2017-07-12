package thiagocury.eti.br.exspinnerarrayadapterapi19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private Spinner spSexo;
    private Button btnOK;

    //ArrayAdapter
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        spSexo = (Spinner) findViewById(R.id.sp_sexo);
        btnOK = (Button) findViewById(R.id.btn_ok);

        //Criando ArrayList para popular Spinner dinamicamente
        ArrayList<String> opcoes = new ArrayList<>();
        //Opções que vão ser inseridas na Spinner
        opcoes.add("Selecione");
        opcoes.add("Masculino");
        opcoes.add("Feminino");

        //Populando Spinner
        adapter = new ArrayAdapter<String>(
                                        MainActivity.this,
                                        android.R.layout.simple_dropdown_item_1line,
                                        opcoes);

        //Setando o adapter na Spinner
        spSexo.setAdapter(adapter);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Testando se o usuário realmente escolheu
                   uma opção da RadioButton */
                if(spSexo.getSelectedItemPosition()!=0) {
                    String sexo = spSexo.getSelectedItem().toString();
                    Toast.makeText(
                            getBaseContext(),
                            "Sexo: " + sexo,
                            LENGTH_LONG).show();
                }else{
                    Toast.makeText(
                            getBaseContext(),
                            "Escolha um sexo!",
                            LENGTH_LONG).show();
                }
            }
        });
    }
}