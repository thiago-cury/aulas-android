package thiagocury.eti.br.exconsumindojsonnetflixrouletteretrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etDiretor;
    private Button btnBuscar;
    private ListView lvFilmes;
    private ProgressBar progress;

    private FilmeAdapter adapter;
    private ArrayList<Filme> filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDiretor = (EditText) findViewById(R.id.et_diretor);
        btnBuscar = (Button) findViewById(R.id.btn_buscar);
        lvFilmes = (ListView) findViewById(R.id.lv_filmes);
        progress = (ProgressBar) findViewById(R.id.progress);

        progress.setVisibility(View.GONE);
        lvFilmes.setVisibility(View.GONE);

        filmes = new ArrayList<>();
        adapter = new FilmeAdapter(MainActivity.this, filmes);
        lvFilmes.setAdapter(adapter);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress.setVisibility(View.VISIBLE);
                lvFilmes.setVisibility(View.VISIBLE);

                getFilmes(etDiretor.getText().toString());

            }
        });
    }

    public void getFilmes(String director) {
        Gson g = new GsonBuilder().registerTypeAdapter(Filme.class, new FilmeDeserializer()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIRetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();

        APIRetrofitService service = retrofit.create(APIRetrofitService.class);

        Call<List<Filme>> callDirector = service.getFilms(director);

        callDirector.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Diretor não registrado no banco de dados!",
                            Toast.LENGTH_LONG).show();
                } else {
                    List<Filme> filmesAux = response.body();

                    for (Filme f : filmesAux) {
                        //Setando no ArrayList
                        filmes.add(f);

                    }
                    adapter.notifyDataSetChanged();
                }
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Algum erro ocorreu: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}