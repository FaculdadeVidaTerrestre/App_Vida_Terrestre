package com.example.vidaterrestre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        Button whatIsLifeButton = findViewById(R.id.whatIsLifeButton);
        Button whyImportantButton = findViewById(R.id.whyImportantButton);
        Button interventionProposalsButton = findViewById(R.id.interventionProposalsButton);
        Button interactiveTestsButton = findViewById(R.id.interactiveTestsButton);
        Button minigameButton = findViewById(R.id.minigameButton);

        // Configurar os listeners para cada botão
        whatIsLifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie uma nova Activity ou exiba informações sobre "O que é a vida terrestre?"
                Intent intent = new Intent(NextActivity.this, WhatIsLifeActivity.class);
                startActivity(intent);
            }
        });

        whyImportantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie uma nova Activity ou exiba informações sobre "Por que é importante?"
                Intent intent = new Intent(NextActivity.this, WhyImportantActivity.class);
                startActivity(intent);
            }
        });

        interventionProposalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie uma nova Activity ou exiba propostas de intervenção
                Intent intent = new Intent(NextActivity.this, InterventionProposalsActivity.class);
                startActivity(intent);
            }
        });

        interactiveTestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie uma nova Activity ou exiba testes interativos
                Intent intent = new Intent(NextActivity.this, InteractiveTestsActivity.class);
                startActivity(intent);
            }
        });

        minigameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie a tela do Minigame
                Intent intent = new Intent(NextActivity.this, MinigameActivity.class);
                startActivity(intent);
            }
        });
    }
}
