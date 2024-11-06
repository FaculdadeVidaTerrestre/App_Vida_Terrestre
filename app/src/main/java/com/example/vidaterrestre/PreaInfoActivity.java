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

public class PreaInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prea_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.prea_title);
        ImageView imageView = findViewById(R.id.prea_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre a Preá");
        imageView.setImageResource(R.drawable.prea_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}