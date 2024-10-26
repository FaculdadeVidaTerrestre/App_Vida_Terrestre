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
                // Lógica para exibir a visualização de animais
            } else {
                toggleButton.setBackgroundResource(R.drawable.button_off);
                // Lógica para exibir a visualização de árvores
            }
        });

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(WhatIsLifeActivity.this, NextActivity.class);
            startActivity(intent);
        });

        Button buttonFilter = findViewById(R.id.button_filter);
        buttonFilter.setOnClickListener(v -> {
            if (mapHandler != null) {
                // Abrir o filtro de estados
                StateFilter stateFilter = new StateFilter(this, mapHandler.getMap());
                stateFilter.showStateFilterDialog();
            }
        });
    }
}
