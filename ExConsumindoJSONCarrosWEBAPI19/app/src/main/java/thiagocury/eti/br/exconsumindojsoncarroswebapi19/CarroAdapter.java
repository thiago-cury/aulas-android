package thiagocury.eti.br.exconsumindojsoncarroswebapi19;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by thiagocury on 23/12/2017.
 */

public class CarroAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Carro> carros;

    public CarroAdapter(Context context, ArrayList<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.linha_carro,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder hold = (ViewHolder) holder;

        Carro c = carros.get(position);

        Log.d("TAG",c.toString());

        hold.tvMarcaCarro.setText(c.getNome());
        hold.tvDescricaoCarro.setText(c.getDesc());

        Picasso.with(context)
                .load(c.getUrlFoto())
                .placeholder(R.mipmap.ic_launcher)
                .into(hold.ivCarro);

    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvMarcaCarro;
        private final TextView tvDescricaoCarro;
        private final ImageView ivCarro;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMarcaCarro = itemView.findViewById(R.id.lc_tv_marca_carro);
            tvDescricaoCarro = itemView.findViewById(R.id.lc_tv_descricao_carro);
            ivCarro = itemView.findViewById(R.id.lc_iv_carro);
        }

    }//fecha class ViewHolder
}//fecha classe

