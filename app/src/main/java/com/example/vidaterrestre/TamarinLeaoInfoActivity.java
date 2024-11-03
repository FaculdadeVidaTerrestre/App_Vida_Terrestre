package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TamarinLeaoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamarin_leao_info);


        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.tamarin_title);
        ImageView imageView = findViewById(R.id.tamarin_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Tamarin Leão Bandeira");
        imageView.setImageResource(R.drawable.tamarin_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}