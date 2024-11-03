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

public class TatuInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tatu_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.tatu_title);
        ImageView imageView = findViewById(R.id.tatu_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Tatu Canastra");
        imageView.setImageResource(R.drawable.tatu_canastra_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}