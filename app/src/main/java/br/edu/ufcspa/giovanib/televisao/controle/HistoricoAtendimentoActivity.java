package br.edu.ufcspa.giovanib.televisao.controle;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ufcspa.giovanib.televisao.R;

public class HistoricoAtendimentoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_atendimento);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // onQueryTextChange é chamado quando o usuário digitar cada caractere no campo de texto;
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // onQueryTextSubmit é acionado quando o botão de busca é pressionado.
        return false;
    }



}
