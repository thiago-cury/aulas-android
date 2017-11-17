package thiagocury.eti.br.exgooglemaps;

import java.util.ArrayList;

/**
 * Created by thiagocury on 05/09/17.
 */

public class Personagem {

    private String nome;
    private int icone;
    private float latitude;
    private float longitude;

    public Personagem() {
    }

    public Personagem(String nome, int icone, float latitude, float longitude) {
        this.nome = nome;
        this.icone = icone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public static ArrayList<Personagem> getPersonagens() {

        ArrayList<Personagem> pers = new ArrayList<>();
        pers.add(new Personagem("Blanka", R.drawable.blankaicon, (float)-30.028033, (float)-51.22353));
        return pers;

    }
}