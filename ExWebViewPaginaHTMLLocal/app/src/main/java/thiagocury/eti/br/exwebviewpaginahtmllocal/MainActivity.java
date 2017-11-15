package thiagocury.eti.br.exwebviewpaginahtmllocal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Widget
    private WebView webView;

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

        //Criando uma página simples para carregar na WebView
        String page = "<!DOCTYPE html>";
        page+= "<html lang='pt-br'>";
        page+= "<head>";
        page+= "<meta charset='UTF-8'>";
        page+= "<title>Exemplo HTML+CSS no Android</title>";
        page+= "<style type='text/css'>";
        page+= "body{";
        page+= "background-color: #FFB74D;";
        page+= "}";
        page+= "</style>";
        page+= "</head>";
        page+= "<body>";
        page+= "<h1>Exemplo HTML+CSS no Android</h1>";
        page+= "<p>ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>";
        page+= "<p>ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>";
        page+= "</body>";
        page+= "</html>";

        webView.loadData(page, "text/html", "UTF-8");

    }
}
