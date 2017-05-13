package thiagocury.eti.br.exbancosqliteprodutoapi19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thiagocury on 12/05/17.
 */
public class ProdutoAdapter extends BaseAdapter{

    private Context context;

    private ArrayList<Produto> prods;
    private LayoutInflater inflater;

    /* Buscando referência dos objetos relacionados ao
       layout da linha (row) do ListView */
    public TextView tvIdProduto;
    public TextView tvNome;
    public TextView tvValorCusto;
    public TextView tvQuantidade;

    public ProdutoAdapter(Context context, ArrayList<Produto> prods) {
        this.context = context;
        this.prods = prods;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void notifyDataSetChanged() {
        // TODO Auto-generated method stub
        super.notifyDataSetChanged();
    }

    public void add(Produto prod){
        prods.add(prod);
    }

    public void remove(Produto prod){
        prods.remove(prod);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return prods.size();
    }

    @Override
    public Produto getItem(int position) {
        // TODO Auto-generated method stub
        return prods.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Produto prod = prods.get(position);

        if(convertView==null) {
          convertView = inflater.inflate(R.layout.linha_produto, null);
        }

        //instâncias dos objetos da linha
        //Guarda a referencia dos objeto
        tvIdProduto = (TextView) convertView.findViewById(R.id.tvIdProduto);
        tvNome = (TextView) convertView.findViewById(R.id.tvNome);
        tvValorCusto = (TextView) convertView.findViewById(R.id.tvValorCusto);
        tvQuantidade = (TextView) convertView.findViewById(R.id.tvQuantidade);

        //Setando o produto na respectiva linha
        tvIdProduto.setText("Código: "+prod.getIdProduto());
        tvNome.setText("Nome: "+prod.getNome());
        tvValorCusto.setText("Valor Custo: R$ "+prod.getValorCusto());
        tvQuantidade.setText("Quantidade: "+prod.getQuantidade());

        return convertView;
    }
}