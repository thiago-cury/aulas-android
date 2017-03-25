package thiagocury.eti.br.extoastapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dessa forma não estamos internacionalizando o projeto.
        Toast.makeText(getBaseContext(),
                    "Olá, mensagem enviada via Toast!",
                    Toast.LENGTH_LONG).show();

        /* Dessa forma estamos internacionalizando o projeto.
        *  Note que estamos chamando o método getResources().getString(), assim
        *  mantemos a internacionalização do nosso projeto com base nas variáveis criadas
        *  dentro do strings.xml */
        Toast.makeText(getBaseContext(),
                getResources().getString(R.string.toast_message),
                Toast.LENGTH_LONG).show();

        /* Toast com Gravity. Assim podemos centralizar o Toast. */
        Toast t = Toast.makeText(
                        getBaseContext(),
                        "Olá, mensagem enviada via Toast!",
                        Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        t.show();
    }
}
