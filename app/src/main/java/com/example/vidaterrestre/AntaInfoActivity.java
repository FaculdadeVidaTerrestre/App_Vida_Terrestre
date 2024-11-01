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

public class AntaInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anta_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.anta_title);
        ImageView imageView = findViewById(R.id.anta_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre a Anta Brasileira");
        imageView.setImageResource(R.drawable.anta_brasileira_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}