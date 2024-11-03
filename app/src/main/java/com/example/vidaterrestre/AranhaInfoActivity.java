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

public class AranhaInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aranha_info);


        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.aranha_title);
        ImageView imageView = findViewById(R.id.aranha_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre a Aranha Caranguejeira");
        imageView.setImageResource(R.drawable.aranha_caranguejeira_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}