package thiagocury.eti.br.exconsumindojsonnetflixrouletteretrofit2;

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
 * Created by thiagocury on 16/07/17.
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
    public Object getItem(int position) {
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

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_imagem);
        TextView tvDiretor = (TextView) convertView.findViewById(R.id.tv_diretor);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tv_titulo);
        TextView tvCategoria = (TextView) convertView.findViewById(R.id.tv_categoria);
        TextView tvSinopse = (TextView) convertView.findViewById(R.id.tv_sinopse);

        tvDiretor.setText(f.getDirector());
        tvTitulo.setText(f.getShow_title());
        tvCategoria.setText(f.getCategory());
        tvSinopse.setText(f.getSummary());

        Glide.with(context)
                .load(f.getPoster())
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);

        return convertView;
    }
}