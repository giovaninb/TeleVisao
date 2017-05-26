package br.edu.ufcspa.giovanib.televisao.controle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ufcspa.giovanib.televisao.R;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);
    }

    public void entrarOnClick(View v){
        String usuarioInformado = usuario.getText().toString();
        String senhaInformada = senha.getText().toString();

        // TODO colocar email nos campos

        // TODO consultar banco de dados para verificar login
        if ("admin".equals(usuarioInformado) && "admin".equals(senhaInformada))
        {
            // vai para outra activity
            String mensagemSucesso = getString(R.string.sucesso_login);
            Toast toast = Toast.makeText(this, mensagemSucesso, Toast.LENGTH_SHORT);
            toast.show();
            startActivity(new Intent(this, DashboardActivity.class));

        }
        else {
            // mostra mensagem de erro
            String mensagemErro = getString(R.string.erro_login);
            Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT);
            toast.show();
            limparCampos();
        }
    }

    public void limparCampos() {
        usuario.setText("");
        senha.setText("");
        usuario.requestFocus();
    }
}
