package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MonkeyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monkey_info);

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.monkeytitle);
        ImageView imageView = findViewById(R.id.monkeyid);
        Button backButton = findViewById(R.id.button_back);

        titleTextView.setText("Informações sobre o macaco");
        imageView.setImageResource(R.drawable.monkey_icon);

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}