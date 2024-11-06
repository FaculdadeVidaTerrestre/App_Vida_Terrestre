package com.example.vidaterrestre;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MoreInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_info_activity);
    }

    // Método chamado quando o botão "Saiba Mais" é clicado
    public void onLearnMoreClicked(View view) {
        // Exemplo de ação: mostrar uma mensagem de feedback
        Toast.makeText(this, "Em breve mais informações sobre a importância da vida terrestre!", Toast.LENGTH_SHORT).show();

        // Ou você pode iniciar uma nova Activity ou abrir um link
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.exemplo.com"));
        // startActivity(intent);
    }
}
