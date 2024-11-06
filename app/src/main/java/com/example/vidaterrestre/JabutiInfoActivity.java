package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JabutiInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jabuti);

        TextView titleTextView = findViewById(R.id.jabuti_title);
        ImageView imageView = findViewById(R.id.jabuti_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Jabuti Piranga");
        imageView.setImageResource(R.drawable.jabuti_piranga);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}