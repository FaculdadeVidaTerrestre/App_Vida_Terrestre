package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JaguarInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaguar_info); // Certifique-se de que o layout correto seja utilizado

        // Referências para os elementos da UI
        TextView titleTextView = findViewById(R.id.jaguar_info_title);
        ImageView imageView = findViewById(R.id.jaguar_info_image);
        TextView descriptionTextView = findViewById(R.id.jaguar_info_description);
        Button backButton = findViewById(R.id.button_back);

        // Definindo informações da onça
        titleTextView.setText("Informações sobre a Onça");
        imageView.setImageResource(R.drawable.jaguar_icon); // Defina a imagem da onça
        descriptionTextView.setText("Descrição completa sobre a onça, seus habitats, status de extinção, etc.");

        // Botão de voltar
        backButton.setOnClickListener(v -> finish());
    }
}
