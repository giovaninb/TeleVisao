package br.edu.ufcspa.giovanib.televisao.client;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ufcspa.giovanib.televisao.controle.LoginActivity;
import br.edu.ufcspa.giovanib.televisao.modelo.Usuario;


/**
 * Created by icaromsc on 13/02/2017.
 */

public class LoginClient extends HttpClient{


    LoginActivity activity;
    public LoginClient(Context context, LoginActivity activity) {
        super(context);
        this.activity=activity;
    }


    public void postJson(JSONObject jsonBody){
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL + "login_app.php", jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("result").equals(0)) {
                        Log.e("Erro", "JSON Post erro");
                    } else {
                        //

                        Log.d("Response JSON", "Login autenticado");
                        Log.d("Response JSON", "JSON Post com sucesso:"+response.toString());
                        Gson gson = new Gson();

                        //converte para usuario
                        Usuario u = gson.fromJson(response.toString(), Usuario.class);
                        Log.d("backend", "gson coverted to Usuario object"+u.toString());
                        activity.autenticar(u);
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
