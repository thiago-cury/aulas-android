package thiagocury.eti.br.exmaterialdialogapi19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Lembrando que para o Material Dialo funcionar
           precisamos sincronizar no gradle a lib:
           compile 'com.afollestad.material-dialogs:core:0.9.4.2' */

        //Dessa forma não estamos internacionalizando o projeto.
        new MaterialDialog.Builder(this)
                .title("Título da Material Dialog")
                .content("Olá, Mensagem enviada a partir de uma MaterialDialog")
                .positiveText("OK")
                .show();

        /* Dessa forma estamos internacionalizando o projeto.
        *  Note que estamos chamando o método getResources().getString(), assim
        *  mantemos a internacionalização do nosso projeto com base nas variáveis criadas
        *  dentro do strings.xml */
        new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.mat_dialog_title))
                .content(getResources().getString(R.string.mat_dialog_message))
                .positiveText(getResources().getString(R.string.mat_dialog_button))
                .show();
    }
}