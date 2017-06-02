package br.edu.ufcspa.giovanib.televisao.controle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import br.edu.ufcspa.giovanib.televisao.R;

import java.util.ArrayList;
import java.util.List;


public class SolicitaAtendimentoActivity extends AppCompatActivity implements OnItemSelectedListener {

    private EditText medicoSolicitante;
    private EditText hospital;
    private EditText andar;
    private EditText leito;
    private EditText descricao;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicita_atendimento);

        // Elemento do Spinner
        spinner = (Spinner) findViewById(R.id.solicHospital);

        // Spinner click listener
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Hospital Santa Clara");
        categories.add("Hospital São Franscisco");
        categories.add("Hospital Santo Antônio");
        categories.add("Hospital São José");
        categories.add("Hospital Santa Rita");
        categories.add("Hospital Dom Vicente");
        categories.add("Pavilhão Pereira Filho");
        categories.add("Posto Santa Maria");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        // Toast.makeText(parent.getContext(), "Selecionado: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    // acao do botao solicitar atendimento
    public void inserirOnClick(View view) {
        Toast.makeText(this, "Solicitação realizada com sucesso!", Toast.LENGTH_LONG).show();

    }


}
