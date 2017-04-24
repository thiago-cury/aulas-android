package thiagocury.eti.br.exentradadedadosedittextcomexpressoesregularesapi19;

/**
 * Created by thiagocury on 24/04/17.
 */

public class Validacao {

    public static boolean validarCodigo(String v){
        String exp = "^[0-9]{2,50}$";
        return v.matches(exp);
    }

    public static boolean validarNome(String v){
        String exp = "^[a-zA-ZÁ-è ]{2,50}$";
        return v.matches(exp);
    }

    public static boolean validarCPF(String v){
        String exp = "^[0-9-.]{5,12}$";
        return v.matches(exp);
    }

    public static boolean validarSalario(String v){
        String exp = "^[0-9.,]{2,20}$";
        return v.matches(exp);
    }
}
