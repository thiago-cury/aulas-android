package thiagocury.eti.br.exgooglemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ArrayList<Personagem> pers = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        //Habilita botão de ver localização atual
        //mMap.setMyLocationEnabled(true);

        //Mostrando localização atual no mapa
        LatLng latLng = new LatLng(-29.76796313, -53.15129235);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //Movimentando o zoom da camera no map
        mMap.moveCamera(CameraUpdateFactory.zoomTo(6));

        //Buscando lista de personagens
        pers = Personagem.getPersonagens();

        if(pers != null) {
            for (int i = 0; i < pers.size(); i++) {
                mMap.addMarker(
                        new MarkerOptions().position(
                                new LatLng(pers.get(i).getLatitude(), pers.get(i).getLongitude())).
                                title(pers.get(i).getNome()).
                                snippet(pers.get(i).getNome()).
                                icon(BitmapDescriptorFactory.fromResource(pers.get(i).getIcone())));
            }
        }
    }
}
