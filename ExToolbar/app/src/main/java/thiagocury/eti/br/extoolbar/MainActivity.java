package thiagocury.eti.br.extoolbar;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Não esquecer de colocar o implementation de suporte design no Build.gradle App
         * Mudar a versão conforme a versão do seu projeto */
        //implementation 'com.android.support:design:26.1.0'

        //Refs.
        toolbar = findViewById(R.id.toolbar);

        //Seta o título da toolbar
        toolbar.setTitle(getResources().getText(R.string.toolbar_titulo));

        //Infla o menu na toolbar
        toolbar.inflateMenu(R.menu.toolbar_menu);

        //Testando menu
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    /* Verificando se clicou no menu sobre */
                    case R.id.toolbar_sobre:
                        Toast.makeText(
                                getBaseContext(),
                                getResources().getText(R.string.toast_menu_sobre),
                                Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }
}