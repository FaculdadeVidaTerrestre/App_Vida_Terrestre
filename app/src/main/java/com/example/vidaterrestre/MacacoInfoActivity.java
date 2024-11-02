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

public class MacacoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macaco_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.macaco_title);
        ImageView imageView = findViewById(R.id.macaco_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Macaco Aranha");
        imageView.setImageResource(R.drawable.macaco_aranha_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}