package thiagocury.eti.br.exbancosqliteprodutoapi19;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by thiagocury on 12/05/17.
 */

public class ProdutoDAO {

    private SQLiteDatabase database;
    private BaseDAO dbHelper;

    public ProdutoDAO(Context context) {
        dbHelper = new BaseDAO(context);
    }

    public void abrirBanco(){
        database = dbHelper.getWritableDatabase();
    }

    public void fecharBanco(){
        dbHelper.close();
    }

    public long inserir(Produto p){
        ContentValues cv = new ContentValues();

        cv.put(BaseDAO.PRODUTO_ID, p.getIdProduto());
        cv.put(BaseDAO.PRODUTO_NOME, p.getNome());
        cv.put(BaseDAO.PRODUTO_VALOR_CUSTO, p.getValorCusto());
        cv.put(BaseDAO.PRODUTO_QUANTIDADE, p.getQuantidade());

        return database.insert(BaseDAO.TBL_PRODUTO, null, cv);
    }

    public long alterar(Produto p){

        long id = p.getIdProduto();

        ContentValues cv = new ContentValues();
        cv.put(BaseDAO.PRODUTO_NOME, p.getNome());
        cv.put(BaseDAO.PRODUTO_VALOR_CUSTO, p.getValorCusto());
        cv.put(BaseDAO.PRODUTO_QUANTIDADE, p.getQuantidade());

        return database.update(
                BaseDAO.TBL_PRODUTO,
                cv,
                BaseDAO.PRODUTO_ID+"=?",
                new String[]{String.valueOf(id)});
    }

    public int excluir(Produto p){

        long id = p.getIdProduto();

        return database.delete(
                BaseDAO.TBL_PRODUTO,
                BaseDAO.PRODUTO_ID+"=?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Produto> consultar(){

        ArrayList<Produto> prodAux = new ArrayList<>();

        /* Consulta para trazer todos os dados de todas as
        *  colunas da tabela produto ordenados pelo nome */
        Cursor cursor = database.query(
                BaseDAO.TBL_PRODUTO,
                BaseDAO.TBL_PRODUTO_COLUNAS,
                null,
                null,
                null,
                null,
                BaseDAO.PRODUTO_NOME); //order by

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Produto p = new Produto();
            p.setIdProduto(cursor.getLong(0));
            p.setNome(cursor.getString(1));
            p.setValorCusto(cursor.getDouble(2));
            p.setQuantidade(cursor.getLong(3));
            cursor.moveToNext();
            prodAux.add(p);
        }

        cursor.close();
        return prodAux;
    }
}