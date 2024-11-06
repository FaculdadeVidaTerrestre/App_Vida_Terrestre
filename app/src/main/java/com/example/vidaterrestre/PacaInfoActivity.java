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

public class PacaInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paca_info);

        TextView titleTextView = findViewById(R.id.paca_title);
        ImageView imageView = findViewById(R.id.paca_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre a Paca");
        imageView.setImageResource(R.drawable.paca_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}