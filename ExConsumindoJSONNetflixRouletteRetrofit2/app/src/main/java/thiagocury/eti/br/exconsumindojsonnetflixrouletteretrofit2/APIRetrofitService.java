package thiagocury.eti.br.exconsumindojsonnetflixrouletteretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by thiagocury on 16/07/17.
 */

public interface APIRetrofitService {

    String BASE_URL = "http://netflixroulette.net/api/";

    @GET("api.php?director=tarantino")
    Call<List<Filme>> getFilmsFixed();

    @GET("api.php")
    Call<List<Filme>> getFilms(@Query("director") String name);
}
