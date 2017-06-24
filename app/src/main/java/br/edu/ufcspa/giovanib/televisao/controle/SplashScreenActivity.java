package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.ListarAtendimentosClient;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarAtendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarAtendimentosRequest;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*ListarAtendimentosClient client = new ListarAtendimentosClient(this);
        ListarAtendimentosRequest request = new ListarAtendimentosRequest();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Log.d("backend", "gson formated usuario:" + gson.toJson(request));

        try {
            client.post(new JSONObject(gson.toJson(request)));
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        }, 2000);
    }

    private void mostrarLogin() {
        Intent intent = new Intent(SplashScreenActivity.this,
                LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
