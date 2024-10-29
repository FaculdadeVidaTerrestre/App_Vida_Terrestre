package com.example.vidaterrestre;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SubmitProposalActivity extends AppCompatActivity {

    private EditText editTextName, editTextTitle, editTextBriefDescription, editTextDetailedDescription;
    private Button btnSubmitProposal;

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

        // Configura o botão de submissão
        btnSubmitProposal.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String title = editTextTitle.getText().toString();
            String briefDescription = editTextBriefDescription.getText().toString();
            String detailedDescription = editTextDetailedDescription.getText().toString();

            // Exemplo: Validação básica (você pode adicionar mais validações se necessário)
            if (name.isEmpty() || title.isEmpty() || briefDescription.isEmpty() || detailedDescription.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                // Lógica para salvar a proposta (outras ações podem ser adicionadas aqui)
                Toast.makeText(this, "Proposta enviada com sucesso!", Toast.LENGTH_SHORT).show();
                finish(); // Encerra a atividade após a submissão
            }
        });
    }
}
