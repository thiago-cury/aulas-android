package thiagocury.eti.br.exbancosqliteprodutoapi19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thiagocury on 12/05/17.
 */

public class BaseDAO  extends SQLiteOpenHelper{

    //Tabela
    public static final String TBL_PRODUTO = "produto";
    public static final String PRODUTO_ID = "idProduto";
    public static final String PRODUTO_NOME = "nome";
    public static final String PRODUTO_VALOR_CUSTO = "valorCusto";
    public static final String PRODUTO_QUANTIDADE = "quantidade";

    /* Colunas da Tabela PRODUTO. São públicos para qualquer classe. */
    public static final String[] TBL_PRODUTO_COLUNAS = {
            BaseDAO.PRODUTO_ID,
            BaseDAO.PRODUTO_NOME,
            BaseDAO.PRODUTO_VALOR_CUSTO,
            BaseDAO.PRODUTO_QUANTIDADE};

    //Banco + name + version
    public static final String DATABASE_NAME = "estoque.sqlite";
    public static final int DATABASE_VERSION = 1;

    //DDL - criação da(s) tabela(s)
    public static final String CREATE_PRODUTO =
            "create table "+TBL_PRODUTO+"(" +
                    PRODUTO_ID+" integer primary key, "+
                    PRODUTO_NOME+" text not null, "+
                    PRODUTO_VALOR_CUSTO+" double not null, "+
                    PRODUTO_QUANTIDADE+" integer not null);";

    //DDL - exclusão da(s) tabela(s)
    public static final String DROP_PRODUTO =
            "drop table if exists " + TBL_PRODUTO;

    public BaseDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Criando a tabela produto */
        db.execSQL(CREATE_PRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}