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
        addPreaOverlay();
        addLagartoOverlay();
        addPreguicaOverlay();
        addMutumOverlay();
        addCurrupiaoOverlay();
        addCutiaOverlay();
        addPapagaioOverlay();
        addAndorinhaOverlay();
        addIguanaOverlay();
        addTatuBolaOverlay();
        addBeijaFlorOverlay();
        addTucanoOverlay();
        addQuatiOverlay();
        addMicoPretoOverlay();
        addSapoCururuOverlay();
        addMicoEstrelaOverlay();
        addGuaxinimOverlay();
        addCobraCoralOverlay();
        addNambuOverlay();
        addPacaOverlay();
        addTuiuiuOverlay();
        addPumaOverlay();
        addJabutiOverlay();
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

    // Acre - Animal principal
    private void addJabutiOverlay() {
        LatLng jabutiLocation = new LatLng(-9.732860, -69.390387);
        GroundOverlayOptions jabutiOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.jabuti_piranga))
                .position(jabutiLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay jabutiOverlay = mMap.addGroundOverlay(jabutiOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(jabutiOverlay)) {
                Intent intent = new Intent(activity, JabutiInfoActivity.class);
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

    // Mato Grosso do Sul - Animal Voador
    private void addTuiuiuOverlay() {
        LatLng tuiuiuLocation = new LatLng(-19.458286, -55.811287);
        GroundOverlayOptions tuiuiuOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tuiuiu_icon))
                .position(tuiuiuLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay tuiuiuOverlay = mMap.addGroundOverlay(tuiuiuOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tuiuiuOverlay)) {
                Intent intent = new Intent(activity, TuiuiuInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Mato Grosso do Sul - Animal em extinção
    private void addPacaOverlay() {
        LatLng pacaLocation = new LatLng(-21.924682, -54.976326);
        GroundOverlayOptions pacaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.paca_icon))
                .position(pacaLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay pacaOverlay = mMap.addGroundOverlay(pacaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(pacaOverlay)) {
                Intent intent = new Intent(activity, PacaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Mato Grosso do Sul - Animal principal
    private void addPumaOverlay() {
        LatLng pumaLocation = new LatLng(-19.748073, -53.262459);
        GroundOverlayOptions pumaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.puma_icon))
                .position(pumaLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay pumaOverlay = mMap.addGroundOverlay(pumaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(pumaOverlay)) {
                Intent intent = new Intent(activity, PumaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Piauí - Animal principal
    private void addIguanaOverlay() {
        LatLng iguanaLocation = new LatLng(-6.099024, -41.858650);
        GroundOverlayOptions iguanaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.iguana_verde_icon))
                .position(iguanaLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay iguanaOverlay = mMap.addGroundOverlay(iguanaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(iguanaOverlay)) {
                Intent intent = new Intent(activity, IguanaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Piauí - Animal em extinção
    private void addTatuBolaOverlay() {
        LatLng tatuBolaLocation = new LatLng(-8.583173, -42.869393);
        GroundOverlayOptions tatuBolaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tatu_bola_icon))
                .position(tatuBolaLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay tatuBolaOverlay = mMap.addGroundOverlay(tatuBolaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tatuBolaOverlay)) {
                Intent intent = new Intent(activity, TatuBolaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Ceará - Preá - Animal principal
    private void addPreaOverlay() {
        LatLng preaLocation = new LatLng(-4.085624, -39.881111);
        GroundOverlayOptions preaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.prea_icon))
                .position(preaLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay preaOverlay = mMap.addGroundOverlay(preaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(preaOverlay)) {
                Intent intent = new Intent(activity, PreaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Ceará - Lagarto Teiu - Animal em extinção
    private void addLagartoOverlay() {
        LatLng lagartoLocation = new LatLng(-6.841331, -39.661385);
        GroundOverlayOptions lagartoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.lagarto_teiu))
                .position(lagartoLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay lagartoOverlay = mMap.addGroundOverlay(lagartoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(lagartoOverlay)) {
                Intent intent = new Intent(activity, LagartoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

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
    private void addPreguicaOverlay() {
        LatLng preguicaLocation = new LatLng(-8.5500, -36.800);
        GroundOverlayOptions preguicaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.bicho_preguica_icon))
                .position(preguicaLocation, 130000f, 130000f)
                .clickable(true);

        GroundOverlay preguicaOverlay = mMap.addGroundOverlay(preguicaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(preguicaOverlay)) {
                Intent intent = new Intent(activity, PreguicaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Alagoas - Animal principal
    private void addMutumOverlay() {
        LatLng mutumLocation = new LatLng(-9.5500, -36.500);
        GroundOverlayOptions mutumOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.mutum_icon))
                .position(mutumLocation, 130000f, 130000f)
                .clickable(true);

        GroundOverlay mutumOverlay = mMap.addGroundOverlay(mutumOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(mutumOverlay)) {
                Intent intent = new Intent(activity, MutumInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Sergipe - Animal principal
    private void addCurrupiaoOverlay() {
        LatLng currupiaoLocation = new LatLng(-10.749108, -37.453133);
        GroundOverlayOptions currupiaoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.currupiao_icon))
                .position(currupiaoLocation, 100000f, 100000f)
                .clickable(true);

        GroundOverlay currupiaoOverlay = mMap.addGroundOverlay(currupiaoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(currupiaoOverlay)) {
                Intent intent = new Intent(activity, CurrupiaoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Bahia - Animal principal
    private void addCutiaOverlay() {
        LatLng cutiaLocation = new LatLng(-11.051174, -43.001229);
        GroundOverlayOptions cutiaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.cutia_icon))
                .position(cutiaLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay cutiaOverlay = mMap.addGroundOverlay(cutiaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(cutiaOverlay)) {
                Intent intent = new Intent(activity, CutiaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Bahia - Animal em extinção
    private void addPapagaioOverlay() {
        LatLng papagaioLocation = new LatLng(-11.309842, -40.364510);
        GroundOverlayOptions papagaioOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.papagaio_cara_roxa_icon))
                .position(papagaioLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay papagaioOverlay = mMap.addGroundOverlay(papagaioOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(papagaioOverlay)) {
                Intent intent = new Intent(activity, PapagaioInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Bahia - Animal voador
    private void addAndorinhaOverlay() {
        LatLng andorinhaLocation = new LatLng(-13.455854, -41.946541);
        GroundOverlayOptions andorinhaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.andorinha_mar_icon))
                .position(andorinhaLocation, 200000f, 200000f)
                .clickable(true);

        GroundOverlay andorinhaOverlay = mMap.addGroundOverlay(andorinhaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(andorinhaOverlay)) {
                Intent intent = new Intent(activity, AndorinhaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

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
    private void addBeijaFlorOverlay() {
        LatLng beijaFlorLocation = new LatLng(-19.872107, -40.562264);
        GroundOverlayOptions beijaFlorOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.beija_flor_icon))
                .position(beijaFlorLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay beijaFlorOverlay = mMap.addGroundOverlay(beijaFlorOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(beijaFlorOverlay)) {
                Intent intent = new Intent(activity, BeijaFlorInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Rio de Janeiro - Animal principal
    private void addTucanoOverlay() {
        LatLng tucanoLocation = new LatLng(-22.534864, -42.847420);
        GroundOverlayOptions tucanoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tucano_icon))
                .position(tucanoLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay tucanoOverlay = mMap.addGroundOverlay(tucanoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(tucanoOverlay)) {
                Intent intent = new Intent(activity, TucanoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // São Paulo - Animal principal
    private void addQuatiOverlay() {
        LatLng quatiLocation = new LatLng(-21.598174, -49.878670);
        GroundOverlayOptions quatiOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.quati_icon))
                .position(quatiLocation, 280000f, 280000f)
                .clickable(true);

        GroundOverlay quatiOverlay = mMap.addGroundOverlay(quatiOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(quatiOverlay)) {
                Intent intent = new Intent(activity, QuatiInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // São Paulo - Animal em extinção
    private void addMicoPretoOverlay() {
        LatLng micoPretoLocation = new LatLng(-22.940164, -48.252693);
        GroundOverlayOptions micoPretoOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.mico_leao_preto_icon))
                .position(micoPretoLocation, 180000f, 200000f)
                .clickable(true);

        GroundOverlay micoPretoOverlay = mMap.addGroundOverlay(micoPretoOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(micoPretoOverlay)) {
                Intent intent = new Intent(activity, MicoPretoInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Paraná - Animal principal
    private void addCobraCoralOverlay() {
        LatLng cobraCoralLocation = new LatLng(-24.228913, -52.691170);
        GroundOverlayOptions cobraCoralOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.cobra_coral_icon))
                .position(cobraCoralLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay cobraCoralOverlay = mMap.addGroundOverlay(cobraCoralOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(cobraCoralOverlay)) {
                Intent intent = new Intent(activity, CobraCoralInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Paraná - Animal em extinção
    private void addNambuOverlay() {
        LatLng nambuLocation = new LatLng(-25.187028, -50.801521);
        GroundOverlayOptions nambuOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.nambu_icon))
                .position(nambuLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay nambuOverlay = mMap.addGroundOverlay(nambuOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(nambuOverlay)) {
                Intent intent = new Intent(activity, NambuInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Santa Catarina - Animal principal
    private void addSapoCururuOverlay() {
        LatLng sapoCururuLocation = new LatLng(-27.080629, -50.054451);
        GroundOverlayOptions sapoCururuOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.sapo_cururu_icon))
                .position(sapoCururuLocation, 150000f, 150000f)
                .clickable(true);

        GroundOverlay sapoCururuOverlay = mMap.addGroundOverlay(sapoCururuOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(sapoCururuOverlay)) {
                Intent intent = new Intent(activity, SapoCururuInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Rio grande do sul - Animal principal
    private void addMicoEstrelaOverlay() {
        LatLng micoEstrelaLocation = new LatLng(-28.557487, -54.141365);
        GroundOverlayOptions micoEstrelaOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.mico_estrela_icon))
                .position(micoEstrelaLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay micoEstrelaOverlay = mMap.addGroundOverlay(micoEstrelaOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(micoEstrelaOverlay)) {
                Intent intent = new Intent(activity, MicoEstrelaInfoActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    // Rio grande do sul - Animal em extinção
    private void addGuaxinimOverlay() {
        LatLng guaxinimLocation = new LatLng(-30.658688, -52.735115);
        GroundOverlayOptions guaxinimOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.guaxinim_icon))
                .position(guaxinimLocation, 150000f, 180000f)
                .clickable(true);

        GroundOverlay guaxinimOverlay = mMap.addGroundOverlay(guaxinimOverlayOptions);

        mMap.setOnGroundOverlayClickListener(overlay -> {
            if (overlay.equals(guaxinimOverlay)) {
                Intent intent = new Intent(activity, GuaxinimInfoActivity.class);
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
