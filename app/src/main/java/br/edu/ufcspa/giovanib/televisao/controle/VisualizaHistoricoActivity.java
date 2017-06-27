package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.ConfirmaAtendimentoClient;
import br.edu.ufcspa.giovanib.televisao.client.HttpClient;

public class VisualizaHistoricoActivity extends AppCompatActivity {

    private TextView nome_usuario_solicitante;
    private TextView perfil_solicitante;
    private TextView nome_paciente;
    private TextView n_prontuario;
    private TextView hospital;
    private TextView andar;
    private TextView status;
    private TextView leito;
    private TextView resumo_clinico;
    private TextView nome_usuario_responsavel;
    private TextView perfil_responsavel;
    private ImageView olho_d;
    private ImageView olho_e;
    private TextView conduta;
    private TextView parecer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_historico);

        SingletonSession singleton = SingletonSession.getInstance();

        nome_usuario_solicitante = (TextView) findViewById(R.id.nome_usuario_solicitante);
        perfil_solicitante = (TextView) findViewById(R.id.perfil_solicitante);
        nome_paciente = (TextView) findViewById(R.id.nome_paciente);
        n_prontuario = (TextView) findViewById(R.id.n_prontuario);
        hospital = (TextView) findViewById(R.id.hospital);
        andar = (TextView) findViewById(R.id.andar);
        leito = (TextView) findViewById(R.id.leito);
        resumo_clinico = (TextView) findViewById(R.id.resumo_clinico);
        status = (TextView) findViewById(R.id.status);
        nome_usuario_responsavel = (TextView) findViewById(R.id.nome_usuario_responsavel);
        perfil_responsavel = (TextView) findViewById(R.id.perfil_responsavel);
        olho_d = (ImageView) findViewById(R.id.img_olhoDireito);
        olho_e = (ImageView) findViewById(R.id.img_olhoEsquerdo);
        conduta = (TextView) findViewById(R.id.conduta);
        parecer = (TextView) findViewById(R.id.parecer);

        nome_usuario_solicitante.setText(nome_usuario_solicitante.getText().toString()+": "+singleton.historicoAtendimentoAtual.getNome_usuario_solicitante());
        perfil_solicitante.setText(perfil_solicitante.getText().toString()+": "+getPerfil(singleton.historicoAtendimentoAtual.getPerfil_solicitante()));
        nome_paciente.setText(nome_paciente.getText().toString()+": "+singleton.historicoAtendimentoAtual.getNome_paciente());
        n_prontuario.setText(n_prontuario.getText().toString()+": "+singleton.historicoAtendimentoAtual.getN_prontuario());
        hospital.setText(hospital.getText().toString()+": "+singleton.historicoAtendimentoAtual.getHospital());
        andar.setText(andar.getText().toString()+": "+singleton.historicoAtendimentoAtual.getAndar());
        status.setText(status.getText().toString()+": "+singleton.historicoAtendimentoAtual.getStatus());
        leito.setText(leito.getText().toString()+": "+singleton.historicoAtendimentoAtual.getLeito());
        resumo_clinico.setText(resumo_clinico.getText().toString()+": \n"+singleton.historicoAtendimentoAtual.getResumo_clinico());
        nome_usuario_responsavel.setText(nome_usuario_responsavel.getText().toString()+": "+singleton.historicoAtendimentoAtual.getNome_usuario_responsavel());
        perfil_responsavel.setText(perfil_responsavel.getText().toString()+": "+getPerfil(singleton.historicoAtendimentoAtual.getPerfil_responsavel()));
        // Carrega imagens

        Picasso.with(this.getApplicationContext()).load(singleton.historicoAtendimentoAtual.getOlho_d()).into(olho_d);
        Picasso.with(this.getApplicationContext()).load(singleton.historicoAtendimentoAtual.getOlho_e()).into(olho_e);

        conduta.setText(singleton.historicoAtendimentoAtual.getConduta());
        parecer.setText(singleton.historicoAtendimentoAtual.getParecer());
    }

    public String getPerfil(String perfil){
        switch (perfil){
            case "A":
               return "Aluno";
            case "P":
                return "Professor";
            case "M":
                return "Médico";
            default:
                return "Profissional";
        }
    }


}
