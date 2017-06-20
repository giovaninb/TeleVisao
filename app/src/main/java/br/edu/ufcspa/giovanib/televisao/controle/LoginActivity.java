package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.client.LoginClient;
import br.edu.ufcspa.giovanib.televisao.modelo.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;
    private static final String PREF_LOGIN = "LoginActivePreferences";
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);

        SharedPreferences sp = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        String autenticado = sp.getString("estado", "");

        if (autenticado.equals("conectado")) {
            startActivity(new Intent(this, DashboardActivity.class));
        }

    }

    public void entrarOnClick(View v) {
        String usuarioInformado = usuario.getText().toString();
        String senhaInformada = senha.getText().toString();

        user = new Usuario(0, "", "", usuarioInformado, senhaInformada);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Log.d("backend", "gson formated usuario:" + gson.toJson(user));


        LoginClient client = new LoginClient(getApplicationContext(), this);
        try {
            client.postJson(new JSONObject(gson.toJson(user)));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void limparCampos() {
        usuario.setText("");
        senha.setText("");
        usuario.requestFocus();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    public void autenticar(Usuario u) {
        boolean exito = u.getId_usuario() != 0;

        if (exito) {
            //TODO Adicionar aqui o objeto usuario na SharedPreferences

            SharedPreferences sp = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            edit.putInt("id", u.getId_usuario());
            edit.putString("nome", u.getNome());
            edit.putString("perfil", u.getPerfil());
            edit.putString("email", u.getEmail());
            edit.putString("senha", u.getSenha());
            edit.putString("estado", "conectado");

            user.setId_usuario(u.getId_usuario());
            user.setNome(u.getNome());
            user.setPerfil(u.getPerfil());
            user.setEmail(u.getEmail());
            user.setSenha(u.getSenha());


            edit.commit();

            Toast.makeText(getApplicationContext(), "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, DashboardActivity.class));
        } else {
            Toast.makeText(getApplicationContext(), "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
            limparCampos();
        }

    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
