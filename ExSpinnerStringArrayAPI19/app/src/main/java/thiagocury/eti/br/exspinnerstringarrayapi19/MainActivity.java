package thiagocury.eti.br.exspinnerstringarrayapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import thiagocury.eti.br.exspinnerstringarrayapi19.model.Usuario;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private Spinner spSexo;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        spSexo = (Spinner) findViewById(R.id.sp_sexo);
        btnOK = (Button) findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario u = new Usuario();
                //Inserindo a escolha do usuário no objeto "u"
                u.setSexo(spSexo.getSelectedItem().toString());

                Toast.makeText(
                        getBaseContext(),
                        "Escolha: "+u.getSexo(),
                        Toast.LENGTH_LONG).show();
            }
        });

        /* Método responsável por disparar no exato momento
           que o usuário escolhe um item da Spinner */
        spSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Testando a posição escolhida pelo usuário
                if(position == 0){
                    Toast.makeText(
                            getBaseContext(),
                            "Você é homem!",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(
                            getBaseContext(),
                            "Você é mulher!",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}