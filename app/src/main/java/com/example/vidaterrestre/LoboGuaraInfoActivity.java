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

public class LoboGuaraInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobo_guara_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.guara_title);
        ImageView imageView = findViewById(R.id.guara_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Lobo Guará");
        imageView.setImageResource(R.drawable.lobo_guara_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}