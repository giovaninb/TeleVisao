package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.edu.ufcspa.giovanib.televisao.R;

public class VisualizaAtendimentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_atendimento);
    }

    public void iniciarOnClick(View v) {
        Toast.makeText(getApplicationContext(), "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, IniciarAtendimentoActivity.class));
    }
}
