package thiagocury.eti.br.exconsumindojsonnetflixrouletteapi19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by thiagocury on 12/05/17.
 */

public class FilmeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Filme> filmes;

    public FilmeAdapter(Context context, ArrayList<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
    }

    @Override
    public int getCount() {
        return filmes.size();
    }

    @Override
    public Filme getItem(int position) {
        return filmes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Filme f = filmes.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.linha_filmes, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivCapa);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
        TextView tvCategoria = (TextView) convertView.findViewById(R.id.tvCategoria);
        TextView tvSumario = (TextView) convertView.findViewById(R.id.tvSumario);

        tvTitulo.setText(f.getDirector());
        tvCategoria.setText(f.getCategory());
        tvSumario.setText(f.getSummary());

        Glide.with(context)
                .load(f.getPoster())
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);

        return convertView;
    }
}