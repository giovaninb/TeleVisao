package br.edu.ufcspa.giovanib.televisao.controle;

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
