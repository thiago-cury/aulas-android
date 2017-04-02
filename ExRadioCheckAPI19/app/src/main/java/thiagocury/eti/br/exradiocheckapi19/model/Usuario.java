package thiagocury.eti.br.exradiocheckapi19.model;

import java.util.ArrayList;

/**
 * Created by thiagocury on 01/04/17.
 */

public class Usuario {

    private String nome;
    private String sexo; //String para guardar o sexo - RadioButton
    private ArrayList<String> interesses; //ArrayList para guardar as opções escolhidas nas CheckBox

    public Usuario() {
    }

    public Usuario(String nome, String sexo, ArrayList<String> interesses) {
        this.nome = nome;
        this.sexo = sexo;
        this.interesses = interesses;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<String> interesses) {
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", interesses=" + interesses +
                '}';
    }
}
