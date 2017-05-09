package thiagocury.eti.br.exmenumaterialdrawercomintentapi19;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    //Drawer
    private Drawer result = null;

    //Toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Menu
        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withToolbar(toolbar)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIdentifier(0).withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("Tela1").withIdentifier(10).withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("Tela2").withIdentifier(20).withIcon(R.mipmap.ic_launcher)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        Intent it;

                        switch ((int)drawerItem.getIdentifier()){
                            case 0:
                                break;

                            case 10:
                                it = new Intent(MainActivity.this, Tela1.class);
                                startActivity(it);
                                break;

                            case 20:
                                it = new Intent(MainActivity.this, Tela2.class);
                                startActivity(it);
                                break;
                        }
                        return false;
                    }
                }).build();
    }
}