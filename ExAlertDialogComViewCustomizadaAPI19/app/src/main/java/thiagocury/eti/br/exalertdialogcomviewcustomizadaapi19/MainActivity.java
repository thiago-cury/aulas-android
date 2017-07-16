package thiagocury.eti.br.exalertdialogcomviewcustomizadaapi19;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View viewAlert = inflater.inflate(R.layout.view_alert, null);
        msg.setView(viewAlert);

        final EditText etNome = (EditText) viewAlert.findViewById(R.id.et_nome);

        msg.setTitle(getResources().getString(R.string.alert_titulo));
        msg.setMessage(getResources().getString(R.string.alert_msg));
        msg.setPositiveButton(getResources().getString(R.string.alert_botao_sim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(
                        getBaseContext(),
                        etNome.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
        msg.setNegativeButton(getResources().getString(R.string.alert_botao_nao), null);
        msg.show();

    }
}
