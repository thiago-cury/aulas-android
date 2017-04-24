package thiagocury.eti.br.exfragmentadicionandodoisestaticosapi19;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    private Button btnFrag2;

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        btnFrag2 = (Button) view.findViewById(R.id.btn_frag2);

        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getActivity().getBaseContext(),
                        "Você está no Fragment 2",
                        Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
