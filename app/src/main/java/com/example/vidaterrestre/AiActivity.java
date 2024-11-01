package com.example.vidaterrestre;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;

public class AiActivity extends AppCompatActivity {

    private List<String> chatMessages;
    private LinearLayout chatContainer;
    private EditText inputAi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ai_activity);

        inputAi = findViewById(R.id.inputAi);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        chatContainer = findViewById(R.id.chatContainer);

        chatMessages = new ArrayList<>();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = inputAi.getText().toString().trim();
                if (!userMessage.isEmpty()) {
                    addMessage("Você: " + userMessage, true); // Adiciona mensagem do usuário à direita
                    modelCall(userMessage);
                    inputAi.setText("");
                }
            }
        });
    }

    private void addMessage(String message, boolean isUserMessage) {
        TextView messageView = new TextView(this);
        messageView.setText(message);
        messageView.setTextColor(getResources().getColor(R.color.branco_gelo));
        messageView.setTextSize(16); // Aumenta o tamanho da fonte em 1px (ou para um tamanho desejado)
        messageView.setPadding(0, 16, 0, 16);
        messageView.setBackgroundResource(isUserMessage ? R.drawable.chat_bubble_user : R.drawable.chat_bubble_ai);

        // Define o espaçamento entre a mensagem do usuário e a mensagem da IA
        if (!isUserMessage) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.gravity = android.view.Gravity.START; // Alinha à esquerda para IA
            params.setMargins(0, 16, 0, 16); // Adiciona um espaço de 16dp acima da mensagem da IA
            chatContainer.addView(messageView, params);
        } else {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.gravity = android.view.Gravity.END; // Alinha à direita para usuário
            chatContainer.addView(messageView, params);
        }
        chatMessages.add(message);
    }

    public void modelCall(String userInput) {
        GenerativeModel gm = new GenerativeModel("gemini-1.5-flash", "AIzaSyCvjGX2ruujNxe5G8Od2JctFZyA47WV1DA"); // Substitua YOUR_API_KEY pela sua chave de API
        GenerativeModelFutures model = GenerativeModelFutures.from(gm);

        // Define o idioma para português
        Content content = new Content.Builder()
                .addText(userInput)
                .build();

        ListenableFuture<GenerateContentResponse> response = model.generateContent(content);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Futures.addCallback(
                    response,
                    new FutureCallback<GenerateContentResponse>() {
                        @Override
                        public void onSuccess(GenerateContentResponse result) {
                            String resultText = result.getText();
                            runOnUiThread(() -> addMessage("IA: " + resultText, false)); // Adiciona resposta da IA à esquerda
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            runOnUiThread(() -> addMessage("Erro: " + t.getMessage(), false)); // Mostra erro da IA
                        }
                    }, this.getMainExecutor());
        }
    }
}
