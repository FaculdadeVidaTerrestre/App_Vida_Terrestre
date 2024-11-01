package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GatoMaracajaInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato_maracaja);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.gato_title);
        ImageView imageView = findViewById(R.id.gato_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Gato Maracajá");
        imageView.setImageResource(R.drawable.gato_maracaja_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}