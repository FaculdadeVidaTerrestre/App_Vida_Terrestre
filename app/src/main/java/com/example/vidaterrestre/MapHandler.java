package com.example.vidaterrestre;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;

import androidx.fragment.app.FragmentActivity;

import com.example.vidaterrestre.JaguarInfoActivity;
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
import java.util.logging.Handler;
public class MapHandler implements OnMapReadyCallback {
    private GoogleMap mMap;
    private FragmentActivity activity;
    private GeoJsonLayer layer; // Mover para um campo de classe
    private boolean isFilterActive = false; // Controle de filtro ativo

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
        addJaguarOverlay();
    }

    private void configureMap() {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        LatLng brazilCenter = new LatLng(-14.2350, -53.9253);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(brazilCenter, 3.9f));

        try {
            layer = new GeoJsonLayer(mMap, R.raw.states, activity);
            GeoJsonPolygonStyle polygonStyle = layer.getDefaultPolygonStyle();
            polygonStyle.setStrokeColor(Color.parseColor("#2E8B57"));
            polygonStyle.setStrokeWidth(5);
            polygonStyle.setFillColor(Color.TRANSPARENT); // Inicialmente sem preenchimento
            layer.addLayerToMap();
        } catch (IOException | JSONException ignored) {
        }
    }

    private void addJaguarOverlay() {
        LatLng jaguarLocation = new LatLng(-3.4168, -65.8561);
        GroundOverlayOptions jaguarOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jaguar_icon))
                .position(jaguarLocation, 400000f, 400000f)
                .clickable(true);

        GroundOverlay jaguarOverlay = mMap.addGroundOverlay(jaguarOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jaguarOverlay)) {
                Intent intent = new Intent(activity, JaguarInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    public void activateStateFilter() {
        if (!isFilterActive) {
            // Inicia a animação de preenchimento
            final int fillColor = Color.argb(128, 46, 139, 87); // Cor de preenchimento (50% opaco)

            // Animação
            ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
            animator.setDuration(500); // 0.5 segundos
            animator.addUpdateListener(valueAnimator -> {
                float fraction = valueAnimator.getAnimatedFraction();
                int alpha = (int) (fillColor & 0xFF * fraction);
                layer.getDefaultPolygonStyle().setFillColor(Color.argb(alpha, 46, 139, 87));
                layer.addLayerToMap();
            });

            animator.addListener(new android.animation.AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    isFilterActive = true; // Marca o filtro como ativo
                }
            });

            animator.start();
        }
    }

    public void clearStateFilter() {
        if (isFilterActive) {
            // Retorna a cor de preenchimento ao estado original
            layer.getDefaultPolygonStyle().setFillColor(Color.TRANSPARENT);
            layer.addLayerToMap(); // Atualiza a camada novamente
            isFilterActive = false; // Marca o filtro como inativo
        }
    }

    public GoogleMap getMap() {
        return mMap;
    }
}
