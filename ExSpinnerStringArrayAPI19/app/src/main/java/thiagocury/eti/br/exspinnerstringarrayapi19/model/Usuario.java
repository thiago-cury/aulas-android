package thiagocury.eti.br.exspinnerstringarrayapi19.model;

/**
 * Created by thiagocury on 02/04/17.
 */

public class Usuario {

    private String sexo;

    public Usuario() {
    }

    public Usuario(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "sexo='" + sexo + '\'' +
                '}';
    }
}
