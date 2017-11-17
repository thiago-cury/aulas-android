package thiagocury.eti.br.exfragmenttrocandoinformacoes;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final FragmentManager fgm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = fgm.beginTransaction();

        //Instanciando os fragments
        Frag1 frag1 = new Frag1();
        ft.add(R.id.frame1, frag1);
        ft.commit();
    }
}