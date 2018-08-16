package thiagocury.eti.br.exeventobotaoonclickonlongclick;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
                                                    //Listeners implementados na classe!
public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        btOK = findViewById(R.id.ma_bt_ok);

        //Setando os Listeners.
        btOK.setOnClickListener(this);
        btOK.setOnLongClickListener(this);

    }//oncreate

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ma_bt_ok:
                //Lembrando que dessa forma não estamos internacionalizando o projeto.
                AlertDialog.Builder alert1 = new AlertDialog.Builder(MainActivity.this);
                alert1.setTitle("Título do alert");
                alert1.setMessage("Você apenas clicou no botão!");
                alert1.setIcon(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher));
                alert1.setNeutralButton("OK",null);
                alert1.show();
                break;
        }//switch
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.ma_bt_ok:
                //Lembrando que dessa forma não estamos internacionalizando o projeto.
                Toast.makeText(getBaseContext(),
                        "Você clicou e segurou o dedo no botão!",
                        Toast.LENGTH_LONG).show();
                break;
        }//switch
        return true;
    }
}//classe