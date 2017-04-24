package thiagocury.eti.br.exlistviewarrayadaptercustomclienteapi19;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thiagocury on 15/04/17.
 */

public class ClienteAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Cliente> clientes;

    public ClienteAdapter(Context context, ArrayList<Cliente> clientes) {
        super(context, 0, clientes);

        this.context = context;
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.linha_cliente,null);
        }

        Cliente c = clientes.get(position);

        TextView tvNome = (TextView) convertView.findViewById(R.id.tv_nome);
        tvNome.setText(c.getNome());

        TextView tvSexo = (TextView) convertView.findViewById(R.id.tv_sexo);
        tvSexo.setText(String.valueOf(c.getSexo()));

        TextView tvRenda = (TextView) convertView.findViewById(R.id.tv_renda);
        tvRenda.setText(String.valueOf(c.getRenda()));

        return convertView;
    }
}