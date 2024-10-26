package com.example.vidaterrestre;

import android.app.AlertDialog;
import android.content.Context;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import java.util.HashMap;
import java.util.Map;

public class StateFilter {
    private Map<String, LatLng> stateCoordinates;
    private Context context;
    private GoogleMap mMap;

    public StateFilter(Context context, GoogleMap map) {
        this.context = context;
        this.mMap = map;
        initializeStateCoordinates();
    }

    private void initializeStateCoordinates() {
        stateCoordinates = new HashMap<>();
        stateCoordinates.put("Acre", new LatLng(-9.0238, -70.8120));
        stateCoordinates.put("Alagoas", new LatLng(-9.5713, -36.7820));
        stateCoordinates.put("Amapá", new LatLng(1.4154, -51.3317));
        stateCoordinates.put("Amazonas", new LatLng(-3.4168, -65.8561));
        stateCoordinates.put("Bahia", new LatLng(-12.5797, -41.7007));
        stateCoordinates.put("Ceará", new LatLng(-5.4984, -39.3206));
        stateCoordinates.put("Distrito Federal", new LatLng(-15.7801, -47.9292));
        stateCoordinates.put("Espírito Santo", new LatLng(-19.1834, -40.3089));
        stateCoordinates.put("Goiás", new LatLng(-15.8270, -49.8362));
        stateCoordinates.put("Maranhão", new LatLng(-4.9609, -45.2746));
        stateCoordinates.put("Mato Grosso", new LatLng(-12.6819, -56.9211));
        stateCoordinates.put("Mato Grosso do Sul", new LatLng(-20.7722, -54.7852));
        stateCoordinates.put("Minas Gerais", new LatLng(-18.5122, -44.5550));
        stateCoordinates.put("Pará", new LatLng(-3.4168, -52.1100));
        stateCoordinates.put("Paraíba", new LatLng(-7.2400, -36.7820));
        stateCoordinates.put("Paraná", new LatLng(-24.9015, -51.5032));
        stateCoordinates.put("Pernambuco", new LatLng(-8.8137, -36.9541));
        stateCoordinates.put("Piauí", new LatLng(-7.7183, -42.7289));
        stateCoordinates.put("Rio de Janeiro", new LatLng(-22.9068, -43.1729));
        stateCoordinates.put("Rio Grande do Norte", new LatLng(-5.7945, -36.4168));
        stateCoordinates.put("Rio Grande do Sul", new LatLng(-30.0346, -51.2177));
        stateCoordinates.put("Rondônia", new LatLng(-10.9472, -62.8278));
        stateCoordinates.put("Roraima", new LatLng(2.7376, -62.0751));
        stateCoordinates.put("Santa Catarina", new LatLng(-27.2423, -50.2189));
        stateCoordinates.put("São Paulo", new LatLng(-23.5505, -46.6333));
        stateCoordinates.put("Sergipe", new LatLng(-10.5741, -37.3857));
        stateCoordinates.put("Tocantins", new LatLng(-10.2500, -48.2973));
    }

    public void showStateFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Selecione o estado: ");

        // Ordena os estados em ordem alfabética
        final String[] states = stateCoordinates.keySet().stream()
                .sorted()
                .toArray(String[]::new);

        builder.setItems(states, (dialog, which) -> {
            String state = states[which];
            LatLng stateCoord = stateCoordinates.get(state);
            if (stateCoord != null) {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(stateCoord, 6.0f));
            }
        });

        builder.setNeutralButton("Limpar Filtros", (dialog, which) -> {
            LatLng brazilCenter = new LatLng(-14.2350, -53.9253);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(brazilCenter, 3.9f));
        });

        builder.show();
    }
}
