package thiagocury.eti.br.exbancosqliteprodutoapi19;

import java.io.Serializable;

/**
 * Created by thiagocury on 12/05/17.
 */

public class Produto implements Serializable {

    private long idProduto;
    private String nome;
    private double valorCusto;
    private long quantidade;

    public Produto() {
    }

    public Produto(long idProduto, String nome, double valorCusto, long quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valorCusto = valorCusto;
        this.quantidade = quantidade;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", valorCusto=" + valorCusto +
                ", quantidade=" + quantidade +
                '}';
    }
}//fecha produto