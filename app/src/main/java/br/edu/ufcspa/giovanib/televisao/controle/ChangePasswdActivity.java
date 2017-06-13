package br.edu.ufcspa.giovanib.televisao.controle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ufcspa.giovanib.televisao.R;

public class ChangePasswdActivity extends AppCompatActivity {

    private EditText senha;
    private CheckBox checkMostrarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_passwd);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        senha = (EditText) findViewById(R.id.novaSenha);
        checkMostrarSenha = (CheckBox) findViewById(R.id.checkMostraSenha);

        // método para visualizar senha antes de alterar
        checkMostrarSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    senha.setTransformationMethod(new PasswordTransformationMethod());
                }
                else
                    senha.setTransformationMethod(null);
            }
        });

    }



    public void alterarOnClick(View view) {
        String mensagemSucesso = "UPDATE para a coluna senha usuario Servidor";
        Toast toast = Toast.makeText(this, mensagemSucesso, Toast.LENGTH_SHORT);
        toast.show();
    }
}
