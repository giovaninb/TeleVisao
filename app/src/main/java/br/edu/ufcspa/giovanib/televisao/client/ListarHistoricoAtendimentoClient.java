package br.edu.ufcspa.giovanib.televisao.client;

import android.content.Context;
import android.util.Log;

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

import br.edu.ufcspa.giovanib.televisao.modelo.ListarHistoricoAtendimento;

import static android.content.ContentValues.TAG;

/**
 * Created by icaromsc on 24/06/2017.
 */

public class ListarHistoricoAtendimentoClient extends HttpClient{

    public ListarHistoricoAtendimentoClient(Context context) {
        super(context);
    }

    public void post(JSONObject json) {
        JsonArrayRequest req = new JsonArrayRequest(URL + "listar_atendimentos.php",
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
                            ArrayList<ListarHistoricoAtendimento> atendimentos = new ArrayList<>();
                            //converte para usuario


                            for (int i = 0; i < response.length(); i++) {

                                // TA AI O MALUCO QUE A GENTE QUER!!!
                                JSONObject person = (JSONObject) response
                                        .get(i);
                                ListarHistoricoAtendimento l = gson.fromJson(person.toString(), ListarHistoricoAtendimento.class);
                                atendimentos.add(l);


                                //Log.d("backend", "gson coverted to ListarAtendimento object:"+l.toString());
                                Log.d("backend","json obj:"+person.toString());

                            }
                            for (ListarHistoricoAtendimento a:atendimentos
                                    ) {
                                Log.d("backend","obj:"+a);
                            }


                            //txtResponse.setText(jsonResponse);

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
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(req);
    }
}
