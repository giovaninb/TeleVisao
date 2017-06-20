package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.modelo.Atendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.CadastroAtendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.EstadoAtendimento;

import java.util.ArrayList;
import java.util.List;


public class SolicitaAtendimentoActivity extends AppCompatActivity implements OnItemSelectedListener {

//    private EditText medicoSolicitante;
    private EditText nomePac;
    private Spinner hospital;
    private EditText andar;
    private EditText leito;
    private EditText descricao;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicita_atendimento);
        //getActionBar().setDisplayHomeAsUpEnabled(true);



        nomePac = (EditText) findViewById(R.id.solicNomePac);
        hospital = (Spinner) findViewById(R.id.solicHospital);
        andar = (EditText) findViewById(R.id.solicAndar);
        leito = (EditText) findViewById(R.id.solicLeito);
        descricao = (EditText) findViewById(R.id.solicDescricao);


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

        // Criando Adapter para Spinner
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
         Toast.makeText(parent.getContext(), "Selecionado: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    // acao do botao solicitar atendimento
    public void inserirOnClick(View view) {



        CadastroAtendimento atendimento = new CadastroAtendimento(2,nomePac.getText().toString(),"12121",
                spinner.getSelectedItem().toString(),
                andar.getText().toString(),leito.getText().toString(),
                descricao.getText().toString());

        Log.d("atendimento","atendimento: "+atendimento.toString());






//        Atendimento atendimento = new Atendimento(nomePac.getText().toString(),hospital.getSelectedItem().toString(),
//                andar.getText().toString(),leito.getText().toString(),descricao.getText().toString(),
//                EstadoAtendimento.DISPONIVEL);


//        List<Atendimento> listaAtendimentos = Atendimento.listAll(Atendimento.class);
//
//        ListView listaDeAtenListView = (ListView) findViewById(R.id.lista);
//
//        //chamada da nossa implementação
//        AdapterListaAtend adapter = new AdapterListaAtend(listaAtendimentos, this);
//
//        listaDeAtenListView.setAdapter(adapter);







        Toast.makeText(this, "Solicitação realizada com sucesso!", Toast.LENGTH_LONG).show();
        limparCampos();

    }

    public void limparCampos() {
        nomePac.setText("");
        hospital.setSelection(0, true);
        andar.setText("");
        leito.setText("");
        descricao.setText("");
        nomePac.requestFocus();
    }


}
