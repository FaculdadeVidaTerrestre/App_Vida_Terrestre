package com.example.vidaterrestre;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SubmitProposalActivity extends AppCompatActivity {

    private EditText editTextName, editTextTitle, editTextBriefDescription, editTextDetailedDescription;
    private Button btnSubmitProposal;
    private TextView textViewCharCount;
    private final int MAX_CHAR_COUNT = 200; // Define o número máximo de caracteres

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_proposal);

        // Inicializa os campos de entrada
        editTextName = findViewById(R.id.editTextName);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextBriefDescription = findViewById(R.id.editTextBriefDescription);
        editTextDetailedDescription = findViewById(R.id.editTextDetailedDescription);
        btnSubmitProposal = findViewById(R.id.btnSubmitProposal);
        textViewCharCount = findViewById(R.id.textViewCharCount); // Inicializa a TextView

        // Adiciona um TextWatcher para contar os caracteres enquanto o usuário digita
        editTextDetailedDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int charCount = s.length();
                textViewCharCount.setText(charCount + "/" + MAX_CHAR_COUNT);

                // Verifica se a descrição ultrapassa o limite
                if (charCount > MAX_CHAR_COUNT) {
                    editTextDetailedDescription.setError("A descrição está muito longa!");
                } else {
                    editTextDetailedDescription.setError(null); // Remove o erro se estiver dentro do limite
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        // Configura o botão de submissão
        btnSubmitProposal.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String title = editTextTitle.getText().toString();
            String briefDescription = editTextBriefDescription.getText().toString();
            String detailedDescription = editTextDetailedDescription.getText().toString();

            // Exemplo: Validação básica (você pode adicionar mais validações se necessário)
            if (name.isEmpty() || title.isEmpty() || briefDescription.isEmpty() || detailedDescription.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else if (detailedDescription.length() > MAX_CHAR_COUNT) {
                // Verifica se a descrição detalhada ultrapassa o limite
                Toast.makeText(this, "A descrição está muito longa!", Toast.LENGTH_SHORT).show();
            } else {
                // Lógica para salvar a proposta (outras ações podem ser adicionadas aqui)
                Toast.makeText(this, "Proposta enviada com sucesso!", Toast.LENGTH_SHORT).show();
                finish(); // Encerra a atividade após a submissão
            }
        });
    }
}
