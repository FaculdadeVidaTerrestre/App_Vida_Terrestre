package com.example.vidaterrestre;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProposalsAdapter extends RecyclerView.Adapter<ProposalsAdapter.ProposalViewHolder> {

    private final List<Proposal> proposals;
    private final InterventionProposalsActivity activity; // Adicione a referência da atividade

    // Atualize o construtor para aceitar a atividade
    public ProposalsAdapter(List<Proposal> proposals, InterventionProposalsActivity activity) {
        this.proposals = proposals;
        this.activity = activity; // Armazena a referência da atividade
    }

    @NonNull
    @Override
    public ProposalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_proposal, parent, false);
        return new ProposalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProposalViewHolder holder, int position) {
        Proposal proposal = proposals.get(position);
        holder.textTitle.setText(proposal.getTitle());
        holder.textDescription.setText(proposal.getBriefDescription()); // Exibe a descrição breve

        // Configura o clique na proposta para abrir detalhes
        holder.itemView.setOnClickListener(v -> {
            if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                activity.showProposalDetails(proposal); // Chama o método na atividade para mostrar os detalhes
            }
        });
    }

    @Override
    public int getItemCount() {
        return proposals.size();
    }

    static class ProposalViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;

        ProposalViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}
