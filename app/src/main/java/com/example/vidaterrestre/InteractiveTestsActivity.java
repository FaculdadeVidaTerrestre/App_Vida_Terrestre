package com.example.vidaterrestre;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class InteractiveTestsActivity extends AppCompatActivity {
    private Button buttonStartQuiz, buttonEndQuiz, instructionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interactive_tests);

        buttonStartQuiz = findViewById(R.id.buttonStartQuiz);
        buttonEndQuiz = findViewById(R.id.buttonEndQuiz);
        instructionBtn = findViewById(R.id.instructionBtn);

        // Habilita o botão "Iniciar Quiz" por padrão
        buttonStartQuiz.setEnabled(true);

        // Ação do botão "Iniciar Quiz"
        buttonStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(InteractiveTestsActivity.this, QuestionActivity.class);
            intent.putExtra("userName", ""); // Você pode deixar vazio ou definir um nome padrão
            intent.putExtra("score", 0); // Inicializa a pontuação com 0
            startActivity(intent);
            finish();
        });

        // Ação para ir para as Instruções
        instructionBtn.setOnClickListener(v -> {
            Intent it = new Intent(InteractiveTestsActivity.this, Instructions.class);
            startActivity(it);
        });

        // Ação do botão "Encerrar Quiz"
        buttonEndQuiz.setOnClickListener(v -> finish());
    }
}
