package br.edu.ufcspa.giovanib.televisao.controle;

/**
 * Created by icaromsc on 19/06/2017.
 */
public class SingletonSession {
    private static SingletonSession ourInstance = new SingletonSession();

    public static SingletonSession getInstance() {
        return ourInstance;
    }

    private SingletonSession() {
    }
}
