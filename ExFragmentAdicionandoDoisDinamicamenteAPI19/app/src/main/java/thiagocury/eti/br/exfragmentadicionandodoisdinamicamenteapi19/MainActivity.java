package thiagocury.eti.br.exfragmentadicionandodoisdinamicamenteapi19;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fgm = getFragmentManager();
        FragmentTransaction ft = fgm.beginTransaction();

        Frag1 frag1 = new Frag1();
        Frag2 frag2 = new Frag2();

        ft.add(R.id.frame1, frag1);
        ft.add(R.id.frame2, frag2);

        ft.commit();
    }
}