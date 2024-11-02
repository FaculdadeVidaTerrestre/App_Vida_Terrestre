package com.example.vidaterrestre;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        RecyclerView recyclerViewProposals = findViewById(R.id.recyclerViewProposals);
        ProposalsAdapter adapter = new ProposalsAdapter(proposalsList, this);
        recyclerViewProposals.setAdapter(adapter);
        recyclerViewProposals.setLayoutManager(new LinearLayoutManager(this));

        // Configurar os hiperlinks para Instagram
        LinearLayout linkContainer1 = findViewById(R.id.linkContainer1);
        linkContainer1.setOnClickListener(v -> openInstagramLink("https://www.instagram.com/greenpeacebrasil/"));

        LinearLayout linkContainer2 = findViewById(R.id.linkContainer2);
        linkContainer2.setOnClickListener(v -> openInstagramLink("https://www.instagram.com/fujama/"));

        LinearLayout linkContainer3 = findViewById(R.id.linkContainer3);
        linkContainer3.setOnClickListener(v -> openInstagramLink("https://www.instagram.com/sosmataatlantica/"));

        // Configurar o botão flutuante para adicionar propostas
        FloatingActionButton fabAddProposal = findViewById(R.id.fabAddProposal);
        fabAddProposal.setOnClickListener(v -> showAddProposalDialog());

        // Configurar o botão de retorno
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> finish());
    }

    // Método para mostrar os detalhes da proposta
    public void showProposalDetails(Proposal proposal) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_proposal_details, null);
        builder.setView(dialogView);

        // Obtém as referências dos TextViews
        TextView titleTextView = dialogView.findViewById(R.id.textProposalTitle);
        TextView briefDescriptionTextView = dialogView.findViewById(R.id.textProposalBriefDescription);
        TextView detailedDescriptionTextView = dialogView.findViewById(R.id.textProposalDetailedDescription);
        Button closeButton = dialogView.findViewById(R.id.btnClose);

        // Define o texto nos TextViews
        titleTextView.setText(proposal.getTitle());
        briefDescriptionTextView.setText(proposal.getBriefDescription());
        detailedDescriptionTextView.setText(proposal.getDetailedDescription());

        // Cria o diálogo antes de configurar o botão de fechar
        AlertDialog dialog = builder.create();

        // Configura o botão de fechar
        closeButton.setOnClickListener(v -> dialog.dismiss());

        // Mostra o diálogo
        dialog.show();
    }

    private void openInstagramLink(String url) {
        Uri uri = Uri.parse(url);
        PackageManager packageManager = getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage("com.instagram.android");

        if (intent != null) {
            intent.setData(uri);
            startActivity(intent);
        } else {
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
        textMessage.setText("Aqui você pode submeter sua proposta.\n");

        Button confirmButton = dialogView.findViewById(R.id.btnConfirm);
        confirmButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SubmitProposalActivity.class);
            startActivity(intent);
        });

        builder.create().show();
    }

    private List<Proposal> getProposals() {
        List<Proposal> proposals = new ArrayList<>();
        proposals.add(new Proposal("Monitoramento de Florestas Nativas", "Acompanhar a saúde das florestas.", "Desenvolver programas de supervisão para salvaguardar as florestas naturais de riscos como o desmatamento, alterações climáticas e incêndios. A vigilância é efetuada através do emprego de drones, satélites e patrulhas locais, que detectam prontamente qualquer degradação ou atividade ilícita. Adicionalmente, esse projeto deve envolver as comunidades locais, proporcionando estímulos para que elas mesmas atuem como protetoras do seu entorno.\n \nA sugestão abrange a criação de bases de dados que documentam a biodiversidade das florestas, auxiliando em pesquisas científicas e políticas de conservação mais fundamentadas.\n"));
        proposals.add(new Proposal("Combate ao Tráfico de Animais Silvestres", "Reduzir o comércio ilegal de animais.", "Esta iniciativa tem como objetivo combater o tráfico ilícito de animais selvagens, uma prática que coloca em risco várias espécies de desaparecer. Para minimizar esse efeito, deve-se intensificar a supervisão nas fronteiras e estabelecer penalidades mais rigorosas para o comércio ilegal. A sugestão engloba uma intensa campanha de sensibilização, evidenciando para a população as consequências do comércio ilegal de animais e estimulando o respaldo da comunidade civil.\n \nAdemais, é essencial apoiar instituições de resgate e recuperação para animais que foram vítimas de tráfico, além de trabalhar em conjunto com organizações internacionais para supervisionar redes de tráfico, evitando ameaças futuras.\n"));
        proposals.add(new Proposal("Educação Ambiental nas Escolas", "Incluir a conservação ambiental no currículo escolar.", "A introdução da educação ambiental no ambiente escolar é uma estratégia eficiente para engajar as novas gerações na defesa da biodiversidade. A sugestão estimula que as matérias escolares tratem de temas como ecologia, conservação de habitats e efeitos das ações humanas na natureza. Atividades práticas, tais como passeios a parques ecológicos, plantação de árvores e estabelecimento de hortas escolares, são essenciais para que os estudantes aprendam de maneira interativa.\n \nAdemais, é crucial incorporar projetos de sensibilização nas instituições de ensino, fomentando a participação dos estudantes em iniciativas de preservação e incentivando-os a disseminar essas informações em suas famílias e comunidades.\n"));
        proposals.add(new Proposal("Agricultura Sustentável", "Promover práticas agrícolas que preservem a natureza.", "A ideia de agricultura sustentável promove o emprego de métodos que garantam a produtividade sem prejudicar o solo e os ecossistemas. Isso engloba métodos como alternância de culturas, compostagem natural e o uso minimizado de pesticidas e adubos químicos. Essas práticas de agricultura previnem a saturação do solo e promovem a regeneração natural da vegetação em torno das culturas. Promover o uso de métodos agroecológicos diminui a demanda por desmatamento, mantendo os habitats naturais de diversas espécies preservados.\n \nA iniciativa também tem como objetivo o suporte a produtores locais, fomentando o consumo responsável de alimentos e fomentando a sustentabilidade no meio rural.\n"));
        proposals.add(new Proposal("O perigo da escassez da água no Brasil", "Previnir crises de água", "As crises de água no Brasil tornaram-se frequentes e cada vez mais sérias, considerando as alterações climáticas. Esta circunstância impacta profundamente a vida na Terra, incluindo animais, plantas e seres humanos, pois todos são dependentes da água para sobreviver, seja como moradia em lagos e rios, uso pessoal ou meio de transporte. O ponto culminante das crises de água aconteceu em 2014 na região sudeste, quando a escassez de chuvas, a má administração pública e a ausência de planejamento levaram ao racionamento e à seca do sistema Cantareira, responsável pelo abastecimento da capital paulista.\n \nAções como poupar água, diminuir tempo no banho e evitar lavar carros com magueira ajudam a previnir crises de água\n"));
        proposals.add(new Proposal("Incentivo ao Reflorestamento", "Restaurar áreas desmatadas.", "É crucial reflorestar regiões degradadas para recuperar a biodiversidade e lutar contra as alterações climáticas. A sugestão incentiva o plantio de árvores locais, contribuindo para a restauração do ecossistema original e fornecendo apoio às espécies locais. Realizam-se mutirões de plantio com a participação da comunidade para promover a sensibilização e a preservação do meio ambiente.\n \nAdicionalmente, o projeto incentiva a conservação constante dessas áreas de plantio, assegurando que as árvores se desenvolvam saudáveis e possam alimentar a fauna local. O plantio de árvores também auxilia na diminuição da temperatura, na restauração do ciclo da água e na melhoria da qualidade do ar.\n"));
        proposals.add(new Proposal("Criação de Jardins Comunitários", "Estimular o cultivo de plantas nativas em áreas urbanas.", "A instalação de jardins comunitários em zonas urbanas contribui para o incremento da biodiversidade local, oferecendo abrigo para polinizadores e outras espécies. A ideia promove o envolvimento da comunidade na produção de plantas locais, que se ajustam ao clima local e requerem menos recursos de água. Esses jardins, além de favorecerem a preservação da biodiversidade, podem atuar como locais de aprendizado e educação ambiental, reforçando o sentimento de comunidade e a ligação dos indivíduos com o meio ambiente.\n"));
        return proposals;
    }
}
