
package thiagocury.eti.br.exconsumindojsoncarroswebapi19;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carro {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("url_foto")
    @Expose
    private String urlFoto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "\nnome =" + nome +
                "\ndesc = " + desc +
                "\nurlFoto = " + urlFoto;
    }
}