package thiagocury.eti.br.exfragmenttrocandoinformacoes;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    //Widgets
    private EditText etNome;
    private Button btnOK;

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag1, container, false);

        etNome = (EditText) v.findViewById(R.id.et_nome);
        btnOK = (Button) v.findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = etNome.getText().toString();

                /* Passando variável para outro Fragment*/
                Bundle data = new Bundle();
                data.putString("nome",nome);
                FragmentManager fgm = getFragmentManager();
                FragmentTransaction ft = fgm.beginTransaction();
                Frag2 frag2 = new Frag2();
                frag2.setArguments(data);
                ft.replace(R.id.frame2, frag2);
                ft.commit();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}
