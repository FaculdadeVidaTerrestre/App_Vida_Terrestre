package com.example.vidaterrestre;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity10 extends AppCompatActivity {
    private RadioGroup radioGroupOptions;
    private Button buttonAnswer;
    private int correctAnswerId = R.id.radioOption2; // Defina a resposta correta
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);

        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        buttonAnswer = findViewById(R.id.buttonAnswer);

        // Recebe a pontuação atual da atividade anterior
        score = getIntent().getIntExtra("score", 0);
        String userName = getIntent().getStringExtra("userName");

        radioGroupOptions.setOnCheckedChangeListener((group, checkedId) -> buttonAnswer.setEnabled(true));

        buttonAnswer.setOnClickListener(v -> {
            int selectedId = radioGroupOptions.getCheckedRadioButtonId();

            // Atualiza a pontuação internamente sem mostrar feedback
            if (selectedId == correctAnswerId) {
                score++;
            }

            // Avança para a próxima atividade de pergunta
            Intent intent = new Intent(QuestionActivity10.this, RankingActivity.class);
            intent.putExtra("userName", userName); // Passa o nome do usuário
            intent.putExtra("score", score);       // Passa a pontuação atualizada
            startActivity(intent);
            finish();
        });
    }
}