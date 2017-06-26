package br.edu.ufcspa.giovanib.televisao.controle;

import java.util.List;

import br.edu.ufcspa.giovanib.televisao.modelo.ListarAtendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarHistoricoAtendimento;

/**
 * Created by icaromsc on 19/06/2017.
 */
public class SingletonSession {
    private static SingletonSession ourInstance = new SingletonSession();

    public static SingletonSession getInstance() {

        if (ourInstance == null)
        {
            ourInstance = new SingletonSession();
        }
        return ourInstance;
    }


    public  int id_usuario;
    public  String nomeUsuario;
    public  String perfil;
    public  List<ListarAtendimento> atendimentos;
    public ListarAtendimento atendimentoAtual;
    public ListarHistoricoAtendimento historicoAtendimentoAtual;



    private SingletonSession() {

    }

    @Override
    public String toString() {
        return "SingletonSession{" +
                "id_usuario=" + id_usuario +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
