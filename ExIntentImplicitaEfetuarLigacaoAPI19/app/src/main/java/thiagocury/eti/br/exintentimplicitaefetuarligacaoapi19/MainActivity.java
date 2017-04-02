package thiagocury.eti.br.exintentimplicitaefetuarligacaoapi19;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNumero;
    private Button btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etNumero = (EditText) findViewById(R.id.et_numero);
        btnLigar = (Button) findViewById(R.id.btn_ligar);

        btnLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Se não possui permissão
                if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //Verifica se já mostramos o alerta e o usuário negou alguma vez.
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)) {
                        //Caso o usuário tenha negado a permissão anteriormente e não tenha marcado o check "nunca mais mostre este alerta"

                        //Podemos mostrar um alerta explicando para o usuário porque a permissão é importante.
                        Toast.makeText(
                                getBaseContext(),
                                "Você já negou antes essa permissão! " +
                                "Para efetuar uma ligação necessitamos dessa permissão!",
                                Toast.LENGTH_LONG).show();

                        /* Além da mensagem indicando a necessidade sobre a permissão,
                           podemos solicitar novamente a permissão */
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);

                    } else {

                        //Solicita a permissão
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);

                    }

                } else {
                    //Tudo OK, podemos prosseguir.
                    String tel = etNumero.getText().toString();
                    Uri uri = Uri.parse("tel:"+tel);
                    Intent it = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(it);
                }
            }
        });
    }
}