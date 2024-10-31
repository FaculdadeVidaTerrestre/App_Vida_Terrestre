package com.example.vidaterrestre;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RankingActivity extends AppCompatActivity {
    private TextView textViewScore;
    private Button buttonRetry, buttonMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        textViewScore = findViewById(R.id.textViewScore);
        buttonRetry = findViewById(R.id.buttonRetry);
        buttonMainMenu = findViewById(R.id.buttonMainMenu);

        // Recebe a pontuação
        int score = getIntent().getIntExtra("score", 0);

        // Exibe apenas a pontuação
        textViewScore.setText("Pontuação: " + score + "/10");

        buttonRetry.setOnClickListener(v -> {
            Intent intent = new Intent(RankingActivity.this, QuestionActivity.class);
            intent.putExtra("score", 0); // Reseta a pontuação
            startActivity(intent);
            finish();
        });

        buttonMainMenu.setOnClickListener(v -> {
            Intent intent = new Intent(RankingActivity.this, InteractiveTestsActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
