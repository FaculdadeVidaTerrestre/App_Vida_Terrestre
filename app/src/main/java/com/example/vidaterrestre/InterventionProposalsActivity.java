package com.example.vidaterrestre;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class InterventionProposalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention_proposals);

        // Inicializa a lista de propostas
        List<Proposal> proposalsList = getProposals();

        // Configure o RecyclerView
        RecyclerView recyclerViewProposals = findViewById(R.id.recyclerViewProposals); // Certifique-se de que o ID corresponda ao XML
        ProposalsAdapter adapter = new ProposalsAdapter(proposalsList);
        recyclerViewProposals.setAdapter(adapter);
        recyclerViewProposals.setLayoutManager(new LinearLayoutManager(this));

        // Configurar o hiperlink para Instagram
        LinearLayout linkContainer = findViewById(R.id.linkContainer);
        linkContainer.setOnClickListener(v -> openInstagramLink());

        // Configurar o botão flutuante para adicionar propostas
        FloatingActionButton fabAddProposal = findViewById(R.id.fabAddProposal);
        fabAddProposal.setOnClickListener(v -> showAddProposalDialog());
    }

    private void openInstagramLink() {
        String instagramPostUrl = "https://www.instagram.com/p/C_yTV9xNZ5A/";
        Uri uri = Uri.parse(instagramPostUrl);

        // Verifica se o Instagram está instalado
        PackageManager packageManager = getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage("com.instagram.android");

        if (intent != null) {
            // Instagram está instalado, abre o link no aplicativo
            intent.setData(uri);
            startActivity(intent);
        } else {
            // Abre o link no navegador se Instagram não está instalado
            intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    private void showAddProposalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_proposal, null);
        builder.setView(dialogView);

        TextView textMessage = dialogView.findViewById(R.id.textMessage);
        textMessage.setText("Aqui você pode submeter sua proposta.");

        Button confirmButton = dialogView.findViewById(R.id.btnConfirm);
        confirmButton.setOnClickListener(v -> {
            Toast.makeText(this, "Tela para submeter proposta", Toast.LENGTH_SHORT).show();
            // Lógica para abrir a tela de submissão de propostas
        });

        builder.create().show();
    }

    private List<Proposal> getProposals() {
        List<Proposal> proposals = new ArrayList<>();
        proposals.add(new Proposal("Título 1", "Descrição da proposta 1"));
        proposals.add(new Proposal("Título 2", "Descrição da proposta 2"));
        proposals.add(new Proposal("Título 3", "Descrição da proposta 3"));
        proposals.add(new Proposal("Título 4", "Descrição da proposta 4"));
        return proposals;
    }
}