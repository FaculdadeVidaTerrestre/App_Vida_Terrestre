package com.example.vidaterrestre;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.google.maps.android.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;

public class MapHandler implements OnMapReadyCallback {
    private GoogleMap mMap;
    private FragmentActivity activity;

    public MapHandler(FragmentActivity activity) {
        this.activity = activity;
    }

    public void initializeMap(SupportMapFragment mapFragment) {
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        configureMap();
        addJaguarOverlay(); // Adicionando a sobreposição da onça
    }

    private void configureMap() {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        LatLng brazilCenter = new LatLng(-14.2350, -53.9253); // Centro do Brasil
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(brazilCenter, 3.9f)); // Zoom para o Brasil

        // Adicionar polígono do Brasil
        try {
            GeoJsonLayer layer = new GeoJsonLayer(mMap, R.raw.states, activity);
            GeoJsonPolygonStyle polygonStyle = layer.getDefaultPolygonStyle();
            polygonStyle.setStrokeColor(Color.BLUE);
            polygonStyle.setStrokeWidth(10);
            layer.addLayerToMap();
        } catch (IOException | JSONException ignored) {
        }
    }

    private void addJaguarOverlay() {
        // Adicionando a sobreposição para a onça
        LatLng jaguarLocation = new LatLng(-3.4168, -65.8561); // Coordenadas da onça

        // Aumentar o tamanho da área de clique em relação ao ícone
        GroundOverlayOptions jaguarOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jaguar_icon)) // Substitua por seu ícone da onça
                .position(jaguarLocation, 400000f, 400000f) // Aumente o tamanho da sobreposição (400 km x 400 km)
                .clickable(true);

        GroundOverlay jaguarOverlay = mMap.addGroundOverlay(jaguarOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jaguarOverlay)) {
                // Aqui você inicia a JaguarInfoActivity
                Intent intent = new Intent(activity, JaguarInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    public GoogleMap getMap() {
        return mMap;
    }
}
