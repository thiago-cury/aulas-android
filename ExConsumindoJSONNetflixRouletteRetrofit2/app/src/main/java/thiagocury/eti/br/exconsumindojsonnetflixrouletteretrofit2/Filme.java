package thiagocury.eti.br.exconsumindojsonnetflixrouletteretrofit2;

/**
 * Created by thiagocury on 16/07/17.
 */

public class Filme {

    private String director;
    private String show_title;
    private String poster;
    private String category;
    private String summary;

    public Filme() {
    }

    public Filme(String director, String show_title, String poster, String category, String summary) {
        this.director = director;
        this.show_title = show_title;
        this.poster = poster;
        this.category = category;
        this.summary = summary;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getShow_title() {
        return show_title;
    }

    public void setShow_title(String show_title) {
        this.show_title = show_title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}