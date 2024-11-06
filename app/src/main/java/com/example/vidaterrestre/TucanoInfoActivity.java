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

public class TucanoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tucano_info);

        TextView titleTextView = findViewById(R.id.tucano_title);
        ImageView imageView = findViewById(R.id.tucano_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o Tucano");
        imageView.setImageResource(R.drawable.tucano_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}