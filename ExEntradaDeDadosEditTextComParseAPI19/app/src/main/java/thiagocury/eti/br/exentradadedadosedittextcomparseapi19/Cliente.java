package thiagocury.eti.br.exentradadedadosedittextcomparseapi19;

/**
 * Created by thiagocury on 22/03/17.
 */

public class Cliente {

    private int codigo;
    private String nome;
    private long CPF;
    private double salario;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, long CPF, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", CPF=" + CPF +
                ", salario=" + salario +
                '}';
    }
}
