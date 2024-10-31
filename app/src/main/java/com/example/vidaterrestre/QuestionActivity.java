package com.example.vidaterrestre;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vidaterrestre.R;

public class QuestionActivity extends AppCompatActivity {
    private RadioGroup radioGroupOptions;
    private Button buttonAnswer;
    private int correctAnswerId = R.id.radioOption2; // Defina a resposta correta
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        buttonAnswer = findViewById(R.id.buttonAnswer);

        // Recebe a pontuação atual da atividade anterior
        String userName = getIntent().getStringExtra("userName");
        score = getIntent().getIntExtra("score", 0);

        radioGroupOptions.setOnCheckedChangeListener((group, checkedId) -> buttonAnswer.setEnabled(true));

        buttonAnswer.setOnClickListener(v -> {
            int selectedId = radioGroupOptions.getCheckedRadioButtonId();

            // Atualiza a pontuação internamente sem mostrar feedback
            if (selectedId == correctAnswerId) {
                score++;
            }

            // Avança para a próxima atividade de pergunta
            Intent intent = new Intent(QuestionActivity.this, QuestionActivity2.class);
            intent.putExtra("userName", userName); // Passa o nome do usuário
            intent.putExtra("score", score);       // Passa a pontuação atualizada
            startActivity(intent);
            finish();

        });
    }
}
