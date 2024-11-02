package com.example.vidaterrestre;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.geojson.GeoJsonFeature;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.google.maps.android.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;

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

    public void highlightState(String stateName) {
        if (layer == null) return; // Verifica se a camada foi inicializada

        for (GeoJsonFeature feature : layer.getFeatures()) {
            // Verifica se a propriedade 'name' do estado corresponde ao nome desejado
            if (stateName.equalsIgnoreCase(feature.getProperty("name"))) {
                GeoJsonPolygonStyle highlightedStyle = new GeoJsonPolygonStyle();
                highlightedStyle.setStrokeColor(Color.RED); // Cor da borda do destaque
                highlightedStyle.setFillColor(Color.argb(128, 255, 165, 0)); // Cor de preenchimento (meio transparente)
                highlightedStyle.setStrokeWidth(8);
                feature.setPolygonStyle(highlightedStyle); // Aplica o estilo de destaque
            } else {
                // Reseta o estilo para o padrão se não for o estado destacado
                GeoJsonPolygonStyle defaultStyle = layer.getDefaultPolygonStyle();
                feature.setPolygonStyle(defaultStyle);
            }
        }
        layer.addLayerToMap(); // Atualiza a camada no mapa
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        configureMap();
        addJaguarOverlay();
        addMonkeyOverlay();
        addAraraOverlay();
        addTamanduaOverlay();
        addCapybaraOverlay();
        addGatoOverlay();
        addAntaOverlay();
        addMacacoOverlay();
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

    // Amazonas - Animal principal
    private void addJaguarOverlay() {
        LatLng jaguarLocation = new LatLng(-2.4168, -65.8561);
        GroundOverlayOptions jaguarOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jaguar_icon))
                .position(jaguarLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay jaguarOverlay = mMap.addGroundOverlay(jaguarOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jaguarOverlay)) {
                Intent intent = new Intent(activity, JaguarInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Amazonas - Animal em extinção
    private void addGatoOverlay() {
        LatLng gatoLocation = new LatLng(-3.5000, -61.100);
        GroundOverlayOptions gatoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.gato_maracaja_icon))
                .position(gatoLocation, 270000f, 270000f)
                .clickable(true);

        GroundOverlay gatoOverlay = mMap.addGroundOverlay(gatoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(gatoOverlay)) {
                Intent intent = new Intent(activity, GatoMaracajaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Amazonas - Animal Voador
    private void addAraraOverlay() {
        LatLng araraLocation = new LatLng(-6.5000, -66.100);
        GroundOverlayOptions araraOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.arara_icon))
                .position(araraLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay araraOverlay = mMap.addGroundOverlay(araraOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(araraOverlay)) {
                Intent intent = new Intent(activity, AraraInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Rondônia - Animal principal
    private void addAntaOverlay() {
        LatLng antaLocation = new LatLng(-11.9000, -61.800);
        GroundOverlayOptions antaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.anta_brasileira_icon))
                .position(antaLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay antaOverlay = mMap.addGroundOverlay(antaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(antaOverlay)) {
                Intent intent = new Intent(activity, AntaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Rondônia - Animal em extinção
    private void addTamanduaOverlay() {
        LatLng tamanduaLocation = new LatLng(-9.9000, -63.800);
        GroundOverlayOptions tamanduaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tamandua_icon))
                .position(tamanduaLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay tamanduaOverlay = mMap.addGroundOverlay(tamanduaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tamanduaOverlay)) {
                Intent intent = new Intent(activity, TamanduaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Roraima - Principal Animal
    private void addMonkeyOverlay() {
        LatLng monkeyLocation = new LatLng(3.4168, -61.200);
        GroundOverlayOptions monkeyOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.monkey_icon))
                .position(monkeyLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay monkeyOverlay = mMap.addGroundOverlay(monkeyOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(monkeyOverlay)) {
                Intent intent = new Intent(activity, MonkeyInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Amapá - Animal Principal
    private void addCapybaraOverlay() {
        LatLng capybaraLocation = new LatLng(1.8000, -51.900);
        GroundOverlayOptions capybaraOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.capivara_icon))
                .position(capybaraLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay capybaraOverlay = mMap.addGroundOverlay(capybaraOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(capybaraOverlay)) {
                Intent intent = new Intent(activity, CapybaraInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Amapá - Animal em extinção
    private void addMacacoOverlay() {
        LatLng macacoLocation = new LatLng(0.199, -51.950);
        GroundOverlayOptions macacoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.macaco_aranha_icon))
                .position(macacoLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay macacoOverlay = mMap.addGroundOverlay(macacoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(macacoOverlay)) {
                Intent intent = new Intent(activity, MacacoInfoActivity.class);
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
                int alpha = (int) ((fillColor & 0xFF) * fraction); // Corrigido com parênteses

                // Define a cor com o novo valor de alpha e mantém os valores RGB
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
