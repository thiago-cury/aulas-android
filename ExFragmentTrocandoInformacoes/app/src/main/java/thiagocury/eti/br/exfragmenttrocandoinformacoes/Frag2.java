package thiagocury.eti.br.exfragmenttrocandoinformacoes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    private TextView tvValor;

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag2, container, false);

        tvValor = (TextView) v.findViewById(R.id.tv_valor);

        String nome = (String) getArguments().getSerializable("nome");

        tvValor.setText("");
        tvValor.setText(nome);

        // Inflate the layout for this fragment
        return v;
    }
}