package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NambuInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nambu);

        TextView titleTextView = findViewById(R.id.nambu_title);
        ImageView imageView = findViewById(R.id.nambu_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Nambu");
        imageView.setImageResource(R.drawable.nambu_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}