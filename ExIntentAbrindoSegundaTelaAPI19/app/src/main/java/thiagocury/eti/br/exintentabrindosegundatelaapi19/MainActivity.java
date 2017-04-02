package thiagocury.eti.br.exintentabrindosegundatelaapi19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Widget
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        btnOK = (Button) findViewById(R.id.btn_ok);

        //Evento do botão
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instanciando uma Intent. Ela será responsável por abrir a segunda Tela
                Intent it = new Intent(MainActivity.this, Tela2.class);
                startActivity(it);

                /* Opcional: Podemos encerrar a MainActivity com a instrução finish(); */
                //finish();
            }
        });
    }
}
