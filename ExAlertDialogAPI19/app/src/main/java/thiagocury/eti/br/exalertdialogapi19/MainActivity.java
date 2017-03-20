package thiagocury.eti.br.exalertdialogapi19;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dessa forma não estamos internacionalizando o projeto.
        AlertDialog.Builder alert1 = new AlertDialog.Builder(MainActivity.this);
        alert1.setTitle("Título do alert");
        alert1.setMessage("Olá, mensagem exibida via Alert!");
        alert1.setIcon(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher));
        alert1.setNeutralButton("OK",null);
        alert1.show();

        /* Dessa forma estamos internacionalizando o projeto.
        *  Note que estamos chamando o método getResources().getString(), assim
        *  mantemos a internacionalização do nosso projeto com base nas variáveis criadas
        *  dentro do strings.xml */
        AlertDialog.Builder alert2 = new AlertDialog.Builder(MainActivity.this);
        alert2.setTitle(getResources().getString(R.string.alert_title));
        alert2.setMessage(getResources().getString(R.string.alert_message));
        alert2.setIcon(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher));
        alert2.setNeutralButton(getResources().getString(R.string.alert_button),null);
        alert2.show();

    }
}
