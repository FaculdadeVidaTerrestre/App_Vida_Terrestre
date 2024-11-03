package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JacarePantanalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacare_pantanal_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.jacare_title);
        ImageView imageView = findViewById(R.id.jacare_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Jacaré do Pantanal");
        imageView.setImageResource(R.drawable.jacare_pantanal_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}