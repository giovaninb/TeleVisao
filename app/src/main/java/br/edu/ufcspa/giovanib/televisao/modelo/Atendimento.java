package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by gnbettoni on 22/05/17.
 */

public class Atendimento {
    private String nomePaciente;
    private String medicoSolicitante;
    private String hospital;
    private String andar;
    private String leito;
    private String descricao;
    private EstadoAtendimento estadoAtendimento;

    public String getMedicoSolicitante() {
        return medicoSolicitante;
    }

    public void setMedicoSolicitante(String medicoSolicitante) {
        this.medicoSolicitante = medicoSolicitante;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EstadoAtendimento getEstadoAtendimento() {
        return estadoAtendimento;
    }

    public void setEstadoAtendimento(EstadoAtendimento estadoAtendimento) {
        this.estadoAtendimento = estadoAtendimento;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
}


