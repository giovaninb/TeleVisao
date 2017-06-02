package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by gnbettoni on 20/05/17.
 */

public class Usuario {

    private String nomeUsuario;
    private EstadoUsuario estadoUsuario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}
