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

public class CapybaraInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capybara_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.capy_title);
        ImageView imageView = findViewById(R.id.capy_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre a Capivara");
        imageView.setImageResource(R.drawable.capivara_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}