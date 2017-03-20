package thiagocury.eti.br.exeventobotaoonclickonlongclickalerttoastapi19;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widget Button
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscando a referência do botão através do seu "id".
        btnOK = (Button) findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Lembrando que dessa forma não estamos internacionalizando o projeto.
                AlertDialog.Builder alert1 = new AlertDialog.Builder(MainActivity.this);
                alert1.setTitle("Título do alert");
                alert1.setMessage("Você apenas clicou no botão!");
                alert1.setIcon(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher));
                alert1.setNeutralButton("OK",null);
                alert1.show();
            }
        });

        btnOK.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //Lembrando que dessa forma não estamos internacionalizando o projeto.
                Toast.makeText(getBaseContext(),
                        "Você clicou e segurou o dedo no botão!",
                        Toast.LENGTH_LONG).show();

                return true;
            }
        });

    }
}
