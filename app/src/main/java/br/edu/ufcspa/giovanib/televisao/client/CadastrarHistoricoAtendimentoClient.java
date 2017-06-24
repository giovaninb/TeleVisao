package br.edu.ufcspa.giovanib.televisao.client;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by icaromsc on 24/06/2017.
 */

public class CadastrarHistoricoAtendimentoClient extends HttpClient{

    public CadastrarHistoricoAtendimentoClient(Context context) {
        super(context);
    }

    public void postJson(JSONObject jsonBody){
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL + "cadastro_historico_atendimento.php", jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("result").equals(0)) {
                        Log.e("Erro", "JSON Post erro");
                    } else {
                        Log.d("backend", "atendimento cadastrado com sucesso");
                        Log.d("backend", "response from web service:" + response.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("erro:",volleyError.toString());
                volleyError.printStackTrace();
            }
        });
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonObjectRequest);
    }



}
