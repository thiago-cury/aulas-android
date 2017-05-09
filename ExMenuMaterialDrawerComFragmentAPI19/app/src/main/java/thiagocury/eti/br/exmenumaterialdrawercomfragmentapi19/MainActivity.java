package thiagocury.eti.br.exmenumaterialdrawercomfragmentapi19;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    //Drawer
    private Drawer result = null;

    //Toolbar
    private Toolbar toolbar;

    private FragmentManager fgm;
    private FragmentTransaction ft;

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
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Tela1").withIdentifier(10).withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("Tela2").withIdentifier(20).withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("Sair").withIdentifier(171).withIcon(R.mipmap.ic_launcher)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch ((int)drawerItem.getIdentifier()){
                            case 0:
                                fgm = getFragmentManager();
                                ft = fgm.beginTransaction();
                                FragHome fragHome = new FragHome();
                                ft.replace(R.id.frame1, fragHome);
                                ft.commit();
                                break;

                            case 10:
                                fgm = getFragmentManager();
                                ft = fgm.beginTransaction();
                                Frag1 frag1 = new Frag1();
                                ft.replace(R.id.frame1, frag1);
                                ft.commit();
                                break;

                            case 20:
                                fgm = getFragmentManager();
                                ft = fgm.beginTransaction();
                                Frag2 frag2 = new Frag2();
                                ft.replace(R.id.frame1, frag2);
                                ft.commit();
                                break;
                            case 171:
                                finish();
                                break;
                        }
                        return false;
                    }
                }).build();
        result.setSelection(0);
    }
}