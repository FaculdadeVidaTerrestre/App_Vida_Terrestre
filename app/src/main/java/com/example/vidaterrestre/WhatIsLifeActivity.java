package com.example.vidaterrestre;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.Locale;

public class WhatIsLifeActivity extends FragmentActivity {
    private MapHandler mapHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuração de idioma para Português-BR
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Definir o layout da atividade
        setContentView(R.layout.whatislife_activity);

        // Configuração do mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapHandler = new MapHandler(this);
        mapHandler.initializeMap(mapFragment);

        // Configuração dos botões
        setUpButtons();
    }

    private void setUpButtons() {
        Button buttonStatView = findViewById(R.id.button_statistical_view);
        buttonStatView.setOnClickListener(v -> {
            Intent intent = new Intent(WhatIsLifeActivity.this, StatisticalViewActivity.class);
            startActivity(intent);
        });

        ToggleButton toggleButton = findViewById(R.id.toggle_button_view);
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleButton.setBackgroundResource(R.drawable.button_on);
                mapHandler.activateStateFilter();
            } else {
                toggleButton.setBackgroundResource(R.drawable.button_off);
                mapHandler.clearStateFilter();
            }
        });

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(WhatIsLifeActivity.this, NextActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        Button buttonFilter = findViewById(R.id.button_filter);
        buttonFilter.setOnClickListener(v -> {
            if (mapHandler != null) {
                StateFilter stateFilter = new StateFilter(this, mapHandler.getMap());
                stateFilter.showStateFilterDialog();
                // Exemplo: Quando um estado é selecionado no filtro
                String selectedStateId = "ID_DO_ESTADO_SELECIONADO"; // Substitua pelo ID do estado
                mapHandler.highlightState(selectedStateId); // Chame o método de destaque
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(WhatIsLifeActivity.this, NextActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Finaliza a atividade atual
    }

}
