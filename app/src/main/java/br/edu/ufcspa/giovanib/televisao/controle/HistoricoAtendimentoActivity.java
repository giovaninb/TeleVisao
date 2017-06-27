package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.HttpClient;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarHistoricoAtendimento;

import static android.content.ContentValues.TAG;

public class HistoricoAtendimentoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    ArrayList<ListarHistoricoAtendimento> atendimentos = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_atendimento);
        listView = (ListView) findViewById(R.id.listViewHistorico);


        post();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingletonSession singleton = SingletonSession.getInstance();
                singleton.historicoAtendimentoAtual= atendimentos.get(position);
                startActivity(new Intent(getBaseContext(), VisualizaHistoricoActivity.class));
            }
        });



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




    public void post() {
        JsonArrayRequest req = new JsonArrayRequest(HttpClient.URL + "listar_historico_atendimentos.php",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d(TAG, response.toString());
                        Log.d("backend","web service response:"+response.toString());
                        try {
                            // Parsing json array response
                            // loop through each json object
                            //jsonResponse = "";
                            Gson gson = new Gson();

                            //converte para usuario


                            for (int i = 0; i < response.length(); i++) {

                                // TA AI O MALUCO QUE A GENTE QUER!!!
                                JSONObject person = (JSONObject) response
                                        .get(i);
                                ListarHistoricoAtendimento l = gson.fromJson(person.toString(), ListarHistoricoAtendimento.class);
                                atendimentos.add(l);
                                Log.d("backend","json obj:"+person.toString());

                            }



                            popularListView();
                        } catch (JSONException e) {
                            e.printStackTrace();
                           /* Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();*/
                        }

                       /* hidepDialog();*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
               /* Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();*/
            }
        });
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(req);
    }


    public void popularListView(){
        Log.d("listview","populando...");
        AdapterListaHistorico adapterListaHistorico = new AdapterListaHistorico(atendimentos,this);
        listView.setAdapter(adapterListaHistorico);
    }


}
