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

public class CobraCoralInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobra_coral_info);

        TextView titleTextView = findViewById(R.id.cobra_coral_title);
        ImageView imageView = findViewById(R.id.cobra_coral_id);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre a Cobra Coral");
        imageView.setImageResource(R.drawable.cobra_coral_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}