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
        addTatuOverlay();
        addQueixadaOverlay();
        addAraraOverlay();
        addTamanduaOverlay();
        addCapybaraOverlay();
        addGatoOverlay();
        addAntaOverlay();
        addMacacoOverlay();
        addAranhaOverlay();
        addLoboOverlay();
        addAraranjubaOverlay();
        addAriranhaOverlay();
        addJaguatiricaOverlay();
        addHarpiaOverlay();
        addTamarinOverlay();
        addTatuPebaOverlay();
        addJacarePantanalOverlay();
        addMorcegoOverlay();
        addCervoOverlay();
        addJaguarundiOverlay();
        addCachorroOverlay();
        addRatoOverlay();
        addCurioOverlay();
        addVeadoOverlay();
        addRaposaOverlay();
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

    // Amazonas - Onça-pintada - Animal principal
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

    // Amazonas - Gato-Maracajá - Animal em extinção
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

    // Amazonas - Arara-azul - Animal Voador
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

    // Rondônia - Anta - Animal principal
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

    // Rondônia - Tamanduá-Bandeira - Animal em extinção
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

    // Roraima - Tatu-canastra - Principal Animal
    private void addTatuOverlay() {
        LatLng tatuLocation = new LatLng(3.0000, -61.200);
        GroundOverlayOptions tatuOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tatu_canastra_icon))
                .position(tatuLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay tatuOverlay = mMap.addGroundOverlay(tatuOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tatuOverlay)) {
                Intent intent = new Intent(activity, TatuInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Roraima - Queixada - Animal em extinção
    private void addQueixadaOverlay() {
        LatLng queixadaLocation = new LatLng(0.7500, -61.200);
        GroundOverlayOptions queixadaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.queixada_icon))
                .position(queixadaLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay queixadaOverlay = mMap.addGroundOverlay(queixadaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(queixadaOverlay)) {
                Intent intent = new Intent(activity, QueixadaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Amapá - Capivara - Animal Principal
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

    // Amapá - Macaco-Aranha - Animal em extinção
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

    // Mato Grosso - Aranha-Caranguejeira - Animal principal
    private void addAranhaOverlay() {
        LatLng aranhaLocation = new LatLng(-11.5000, -57.800);
        GroundOverlayOptions aranhaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.aranha_caranguejeira_icon))
                .position(aranhaLocation, 450000f, 450000f)
                .clickable(true);

        GroundOverlay aranhaOverlay = mMap.addGroundOverlay(aranhaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(aranhaOverlay)) {
                Intent intent = new Intent(activity, AranhaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Mato Grosso - Lobo-Guará - Animal em extinção
    private void addLoboOverlay() {
        LatLng loboLocation = new LatLng(-14.9000, -55.800);
        GroundOverlayOptions loboOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.lobo_guara_icon))
                .position(loboLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay loboOverlay = mMap.addGroundOverlay(loboOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(loboOverlay)) {
                Intent intent = new Intent(activity, LoboGuaraInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Mato Grosso - Araranjuba - Animal voador
    private void addAraranjubaOverlay() {
        LatLng araranjubaLocation = new LatLng(-11.9000, -52.900);
        GroundOverlayOptions araranjubaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.araranjuba_icon))
                .position(araranjubaLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay araranjubaOverlay = mMap.addGroundOverlay(araranjubaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(araranjubaOverlay)) {
                Intent intent = new Intent(activity, AraranjubaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Pará - Jaguatirica - Animal principal
    private void addJaguatiricaOverlay() {
        LatLng jaguatiricaLocation = new LatLng(-3.9000, -54.800);
        GroundOverlayOptions jaguatiricaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jaguatirica_icon))
                .position(jaguatiricaLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay jaguatiricaOverlay = mMap.addGroundOverlay(jaguatiricaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jaguatiricaOverlay)) {
                Intent intent = new Intent(activity, JaguatiricaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Pará - Ariranha - Animal em extinção
    private void addAriranhaOverlay() {
        LatLng ariranhaLocation = new LatLng(-3.9000, -50.800);
        GroundOverlayOptions ariranhaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.ariranha_icon))
                .position(ariranhaLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay ariranhaOverlay = mMap.addGroundOverlay(ariranhaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(ariranhaOverlay)) {
                Intent intent = new Intent(activity, AriranhaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Pará - Gavião Real - Animal voador
    private void addHarpiaOverlay() {
        LatLng harpiaLocation = new LatLng(-6.9000, -53.800);
        GroundOverlayOptions harpiaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.harpia_icon))
                .position(harpiaLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay harpiaOverlay = mMap.addGroundOverlay(harpiaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(harpiaOverlay)) {
                Intent intent = new Intent(activity, HarpiaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Maranhão - Tatu Peba - Animal principal
    private void addTatuPebaOverlay() {
        LatLng tatuPebaLocation = new LatLng(-3.9000, -44.800);
        GroundOverlayOptions tatuPebaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tatu_peba_icon))
                .position(tatuPebaLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay tatuPebaOverlay = mMap.addGroundOverlay(tatuPebaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tatuPebaOverlay)) {
                Intent intent = new Intent(activity, TatuPebaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Maranhão - Tamarin Leão Bandeira - Animal em extinção
    private void addTamarinOverlay() {
        LatLng tamarinLocation = new LatLng(-6.0000, -46.300);
        GroundOverlayOptions tamarinOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tamarin_icon))
                .position(tamarinLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay tamarinOverlay = mMap.addGroundOverlay(tamarinOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tamarinOverlay)) {
                Intent intent = new Intent(activity, TamarinLeaoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Tocantins - Jacaré do Pantanal - Animal principal
    private void addJacarePantanalOverlay() {
        LatLng jacareLocation = new LatLng(-8.3000, -48.300);
        GroundOverlayOptions jacareOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jacare_pantanal_icon))
                .position(jacareLocation, 220000f, 220000f)
                .clickable(true);

        GroundOverlay jacareOverlay = mMap.addGroundOverlay(jacareOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jacareOverlay)) {
                Intent intent = new Intent(activity, JacarePantanalInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Tocantins - Morcego-de-fruta - Animal em extinção
    private void addMorcegoOverlay() {
        LatLng morcegoLocation = new LatLng(-11.2000, -48.300);
        GroundOverlayOptions morcegoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.morcego_fruta_icon))
                .position(morcegoLocation, 310000f, 310000f)
                .clickable(true);

        GroundOverlay morcegoOverlay = mMap.addGroundOverlay(morcegoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(morcegoOverlay)) {
                Intent intent = new Intent(activity, MorcegoFrutaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Goias - Cervo do Pantanal - Animal principal
    private void addCervoOverlay() {
        LatLng cervoLocation = new LatLng(-14.8000, -49.2000);
        GroundOverlayOptions cervoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.cervo_pantanal_icon))
                .position(cervoLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay cervoOverlay = mMap.addGroundOverlay(cervoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(cervoOverlay)) {
                Intent intent = new Intent(activity, CervoPantanalInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Goias - Jaguarundi - Animal em extinção
    private void addJaguarundiOverlay() {
        LatLng jaguarundiLocation = new LatLng(-17.6000, -50.800);
        GroundOverlayOptions jaguarundiOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jaguarundi_icon))
                .position(jaguarundiLocation, 250000f, 250000f)
                .clickable(true);

        GroundOverlay jaguarundiOverlay = mMap.addGroundOverlay(jaguarundiOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jaguarundiOverlay)) {
                Intent intent = new Intent(activity, JaguatiricaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Mato Grosso do Sul - Animal principal

    // Mato Grosso do Sul - Animal em extinção

    // Piauí - Animal principal

    // Piauí - Animal em extinção

    // Ceará - Animal principal
    // Ceará - Animal em extinção

    // Rio grande do norte - Veado-Catingueiro - Animal principal
    private void addVeadoOverlay() {
        LatLng veadoLocation = new LatLng(-5.7000, -36.500);
        GroundOverlayOptions veadoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.veado_icon))
                .position(veadoLocation, 130000f, 130000f)
                .clickable(true);

        GroundOverlay veadoOverlay = mMap.addGroundOverlay(veadoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(veadoOverlay)) {
                Intent intent = new Intent(activity, VeadoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Paraíba - Raposa-Campeira - Animal principal
    private void addRaposaOverlay() {
        LatLng raposaLocation = new LatLng(-7.3500, -36.200);
        GroundOverlayOptions raposaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.raposa_icon))
                .position(raposaLocation, 130000f, 130000f)
                .clickable(true);

        GroundOverlay raposaOverlay = mMap.addGroundOverlay(raposaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(raposaOverlay)) {
                Intent intent = new Intent(activity, RaposaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Pernambuco - Animal principal

    // Alagoas - Animal principal

    // Sergipe - Animal principal

    // Bahia - Animal principal
    // Bahia - Animal em extinção

    // Minas Gerais - Cachorro-do-Mato - Animal principal
    private void addCachorroOverlay() {
        LatLng cachorroLocation = new LatLng(-20.2000, -44.300);
        GroundOverlayOptions cachorroOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.cachorro_do_mato_icon))
                .position(cachorroLocation, 300000f, 300000f)
                .clickable(true);

        GroundOverlay cachorroOverlay = mMap.addGroundOverlay(cachorroOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(cachorroOverlay)) {
                Intent intent = new Intent(activity, CachorroMatoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Minas Gerais - Rato-do-Mato - Animal em extinção
    private void addRatoOverlay() {
        LatLng ratoLocation = new LatLng(-17.2000, -42.300);
        GroundOverlayOptions ratoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.rato_do_mato_icon))
                .position(ratoLocation, 280000f, 280000f)
                .clickable(true);

        GroundOverlay ratoOverlay = mMap.addGroundOverlay(ratoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(ratoOverlay)) {
                Intent intent = new Intent(activity, RatoMatoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Minas Gerais - Curió - Animal voador
    private void addCurioOverlay() {
        LatLng curioLocation = new LatLng(-17.2000, -45.300);
        GroundOverlayOptions curioOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.curio_icon))
                .position(curioLocation, 280000f, 280000f)
                .clickable(true);

        GroundOverlay curioOverlay = mMap.addGroundOverlay(curioOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(curioOverlay)) {
                Intent intent = new Intent(activity, CurioInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Espirito Santo - Animal principal

    // Rio de Janeiro - Animal principal

    // São Paulo - Animal principal
    // São Paulo - Animal em extinção

    // Paraná - Animal principal
    // Paraná - Animal em extinção

    // Santa Catarina - Animal principal
    // Santa Catarina - Animal em extinção

    // Rio grande do sul - Animal principal
    // Rio grande do sul - Animal em extinção
    // Rio grande do sul - Animal voador


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
