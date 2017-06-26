package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.ConfirmaAtendimentoClient;

public class VisualizaAtendimentoActivity extends AppCompatActivity {


    private TextView usuarioSolicitante;
    private TextView nomePaciente;
    private TextView hospital;
    private TextView andar;
    private TextView leito;
    private TextView resumo_clinico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_atendimento);

        SingletonSession singleton = SingletonSession.getInstance();

        usuarioSolicitante = (TextView) findViewById(R.id.atend_usuario_solic);
        nomePaciente = (TextView) findViewById(R.id.atend_nomePac);
        hospital = (TextView) findViewById(R.id.atend_hospital);
        andar = (TextView) findViewById(R.id.atend_andar);
        leito = (TextView) findViewById(R.id.atend_leito);
        resumo_clinico = (TextView) findViewById(R.id.atend_resumo_clinico);

        usuarioSolicitante.setText(singleton.atendimentoAtual.getNome_usuario_solicitante());
        nomePaciente.setText(singleton.atendimentoAtual.getNome_paciente());
        hospital.setText(singleton.atendimentoAtual.getHospital());
        andar.setText(singleton.atendimentoAtual.getAndar());
        leito.setText(singleton.atendimentoAtual.getLeito());
        resumo_clinico.setText(singleton.atendimentoAtual.getResumo_clinico());

    }



    public void iniciarOnClick(View v) {
        ConfirmaAtendimentoClient client = new ConfirmaAtendimentoClient(this);
        SingletonSession singleton = SingletonSession.getInstance();
        client.send(singleton.atendimentoAtual.getId_atendimento());
        Toast.makeText(getApplicationContext(), "Atendimento confirmado com sucesso!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, RegistrarHistoricoAtendimentoActivity.class));
        finish();
    }



}
