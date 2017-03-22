package thiagocury.eti.br.exsnackbarapi19;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referências
        btnOK = (Button) findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Lembrando que para a SnackBar funcionar precisamos importar a lib:
                   import android.support.design.widget.Snackbar; */

                /* Além de sincronizar no gradle a lib de support ao design:
                   compile 'com.android.support:design:25.3.0' */

                //SnackBar internacionalizada
                Snackbar.make(
                        view,
                        getResources().getString(R.string.snack_message),
                        Snackbar.LENGTH_LONG).setAction("Action", null).show();

                //SnackBar não internacionalizada

                /*Snackbar.make(
                        view,
                        "Olá, mensagem enviada via SnackBar!",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show();*/
            }
        });
    }
}