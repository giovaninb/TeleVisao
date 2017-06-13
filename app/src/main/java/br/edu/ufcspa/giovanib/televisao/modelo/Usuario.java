package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by gnbettoni on 20/05/17.
 */

public class Usuario {
    private int id_usuario;
    private String nome;
    private String perfil;
    private String email;
    private String senha;
    private EstadoUsuario estadoUsuario;

    public Usuario(int id_usuario, String nome, String perfil, String email, String senha) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.perfil = perfil;
        this.email = email;
        this.senha = senha;
    }


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nome='" + nome + '\'' +
                ", perfil='" + perfil + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
