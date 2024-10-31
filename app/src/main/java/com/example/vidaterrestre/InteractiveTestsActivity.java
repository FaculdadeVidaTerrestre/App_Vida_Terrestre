package com.example.vidaterrestre;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InteractiveTests extends AppCompatActivity {
    private EditText editTextName;
    private Button buttonStartQuiz, buttonEndQuiz, instructionBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interactive_tests);

        // Sincronizando com os IDs do XML
        /* TextView textStudentInfo1 = findViewById(R.id.textStudentInfo1);
        ImageView imageStudent1 = findViewById(R.id.imageStudent1);
        TextView textStudentInfo2 = findViewById(R.id.textStudentInfo2); */

        editTextName = findViewById(R.id.editTextName);
        buttonStartQuiz = findViewById(R.id.buttonStartQuiz);
        buttonEndQuiz = findViewById(R.id.buttonEndQuiz);
        instructionBtn = findViewById(R.id.instructionBtn);

        // Listener para habilitar o botão "Iniciar Quiz" apenas quando o nome for digitado
        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buttonStartQuiz.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Ação do botão "Iniciar Quiz"
        buttonStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(InteractiveTests.this, QuestionActivity.class);
            intent.putExtra("userName", editTextName.getText().toString());
            intent.putExtra("score", 0); // Inicializa a pontuação com 0
            startActivity(intent);
        });
        // Ação para ir para as Instruções
        instructionBtn.setOnClickListener(v -> {
            Intent it = new Intent(InteractiveTests.this, Instructions.class);
            startActivity(it);
        });
        // Ação do botão "Encerrar Quiz"
        buttonEndQuiz.setOnClickListener(v -> finishAffinity());
    }
}
