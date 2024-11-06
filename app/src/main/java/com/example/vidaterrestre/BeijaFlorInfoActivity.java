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

public class BeijaFlorInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beija_flor_info);

        TextView titleTextView = findViewById(R.id.beija_flor_title);
        ImageView imageView = findViewById(R.id.beija_flor_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Beija Flor");
        imageView.setImageResource(R.drawable.beija_flor_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}