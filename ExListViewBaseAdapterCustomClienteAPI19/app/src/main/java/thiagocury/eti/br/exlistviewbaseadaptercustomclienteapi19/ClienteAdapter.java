package thiagocury.eti.br.exlistviewbaseadaptercustomclienteapi19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thiagocury on 15/04/17.
 */

public class ClienteAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Cliente> clientes;
    private LayoutInflater inflater;

    public ClienteAdapter(Context context, ArrayList<Cliente> clientes) {
        this.context = context;
        this.clientes = clientes;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Cliente getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.linha_cliente, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Cliente c = getItem(position);

        holder.tvNome.setText(c.getNome());
        holder.tvSexo.setText(c.getSexo());
        holder.tvRenda.setText(String.valueOf(c.getRenda()));

        return convertView;
    }

    static class ViewHolder{
        private TextView tvNome;
        private TextView tvSexo;
        private TextView tvRenda;

        public ViewHolder(View v){
            tvNome = (TextView) v.findViewById(R.id.tv_nome);
            tvSexo = (TextView) v.findViewById(R.id.tv_sexo);
            tvRenda = (TextView) v.findViewById(R.id.tv_renda);
        }
    }
}
