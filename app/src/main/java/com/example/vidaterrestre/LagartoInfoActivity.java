package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LagartoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagarto_info);

        TextView titleTextView = findViewById(R.id.lagarto_title);
        ImageView imageView = findViewById(R.id.lagarto_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Lagarto Teiú");
        imageView.setImageResource(R.drawable.lagarto_teiu);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}