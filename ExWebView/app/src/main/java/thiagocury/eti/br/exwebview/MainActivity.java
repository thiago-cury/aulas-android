package thiagocury.eti.br.exwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    //Widget
    private WebView webView;

    private static final String URL = "http://www.thiagocury.eti.br";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Não esquecer de inserir a permissão de internet no AndroidManifest
           <uses-permission android:name="android.permission.INTERNET"/> */

        //Ref.
        /* A partir do Android 3.0 Alpha não é necessário fazer o CAST para o Widget.*/
        webView = findViewById(R.id.webView);

        //Setando suporte para JavaScript
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        webView.loadUrl(URL);

    }
}