package thiagocury.eti.br.exrecyclerviewcardviewpicassoclienteapi19;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by thiagocury on 19/04/17.
 */
public class ClienteAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Cliente> clientes;

    public ClienteAdapter(Context context, ArrayList<Cliente> clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.linha_cliente, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder hold = (ViewHolder) holder;
        Cliente cli = clientes.get(position);

        hold.tvNome.setText(cli.getNome());
        hold.tvSexo.setText(cli.getSexo());
        hold.tvRenda.setText(String.valueOf(cli.getRenda()));

        if(cli.getSexo().equalsIgnoreCase("Masculino")){
            Picasso.with(context)
                    .load("http://www.produtivit.com.br/img/icone.png")
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(hold.ivSexo);
        }else{
            Picasso.with(context)
                    .load("http://icon-icons.com/icons2/11/PNG/256/customer_person_people_woman_you_1627.png")
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(hold.ivSexo);
        }
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvNome;
        final TextView tvSexo;
        final TextView tvRenda;
        final ImageView ivSexo;

        public ViewHolder(View v) {
            super(v);
            tvNome = (TextView) v.findViewById(R.id.tv_nome);
            tvSexo = (TextView) v.findViewById(R.id.tv_sexo);
            tvRenda = (TextView) v.findViewById(R.id.tv_renda);
            ivSexo = (ImageView) v.findViewById(R.id.iv_sexo);
        }
    }
}