package thiagocury.eti.br.exradiocheckapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import thiagocury.eti.br.exradiocheckapi19.model.Usuario;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private RadioButton rdMasculino;
    private RadioButton rdFeminino;
    private RadioGroup rgSexo;
    private CheckBox chAndroid;
    private CheckBox chIOS;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etNome = (EditText) findViewById(R.id.et_nome);
        rdMasculino = (RadioButton) findViewById(R.id.rd_masculino);
        rdFeminino = (RadioButton) findViewById(R.id.rd_feminino);
        rgSexo = (RadioGroup) findViewById(R.id.rg_sexo);
        chAndroid = (CheckBox) findViewById(R.id.ch_android);
        chIOS = (CheckBox) findViewById(R.id.ch_ios);
        btnOK = (Button) findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario u = new Usuario();

                u.setNome(etNome.getText().toString());

                /* Para testar RadioButton no Android devemos buscar o id da RadioButton marcada
                 * através do grupo e testar com os ids de cada RadioButton */
                if(rgSexo.getCheckedRadioButtonId() == rdMasculino.getId()) {
                    u.setSexo(rdMasculino.getText().toString());
                }else{
                    u.setSexo(rdFeminino.getText().toString());
                }

                ArrayList<String> interesses = new ArrayList<String>();
                if(chAndroid.isChecked()){
                    interesses.add(chAndroid.getText().toString());
                }
                if(chIOS.isChecked()){
                    interesses.add(chIOS.getText().toString());
                }
                //Enviar os interesses escolhidos pelos usuário para o objeto "u"
                u.setInteresses(interesses);

                Toast.makeText(
                        getBaseContext(),
                        "Dados cadastrados: "+u.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }//fecha oncreate
}//fecha classe