package thiagocury.eti.br.exintentimplicitanativaapi19;

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
    private EditText etTexto;
    private Button btnBrowser;
    private Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        etTexto = (EditText) findViewById(R.id.et_texto);
        btnBrowser = (Button) findViewById(R.id.btn_browser);
        btnDial = (Button) findViewById(R.id.btn_dial);

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent Implícita
                Uri uri = Uri.parse("http://"+etTexto.getText().toString());
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent Implícita
                Uri uri = Uri.parse("tel:"+etTexto.getText().toString());
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }
        });
    }
}