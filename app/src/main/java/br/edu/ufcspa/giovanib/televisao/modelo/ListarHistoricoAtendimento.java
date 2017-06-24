package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by icaromsc on 24/06/2017.
 */

public class ListarHistoricoAtendimento {

    private int id_historico_atendimento;
    private int id_atendimento;
    private int id_solicitante;
    private String nome_usuario_solicitante;
    private String perfil_solicitante;
    private int id_paciente;
    private String nome_paciente;
    private String n_prontuario;
    private String hospital;
    private String andar;
    private String status;
    private String leito;
    private String resumo_clinico;
    private int id_responsavel;
    private String nome_usuario_responsavel;
    private String perfil_responsavel;
    private String conduta;
    private String olho_d;
    private String olho_e;
    private String parecer;

    public ListarHistoricoAtendimento(int id_historico_atendimento, int id_atendimento, int id_solicitante, String nome_usuario_solicitante, String perfil_solicitante, int id_paciente, String nome_paciente, String n_prontuario, String hospital, String andar, String status, String leito, String resumo_clinico, int id_responsavel, String nome_usuario_responsavel, String perfil_responsavel, String conduta, String olho_d, String olho_e, String parecer) {
        this.id_historico_atendimento = id_historico_atendimento;
        this.id_atendimento = id_atendimento;
        this.id_solicitante = id_solicitante;
        this.nome_usuario_solicitante = nome_usuario_solicitante;
        this.perfil_solicitante = perfil_solicitante;
        this.id_paciente = id_paciente;
        this.nome_paciente = nome_paciente;
        this.n_prontuario = n_prontuario;
        this.hospital = hospital;
        this.andar = andar;
        this.status = status;
        this.leito = leito;
        this.resumo_clinico = resumo_clinico;
        this.id_responsavel = id_responsavel;
        this.nome_usuario_responsavel = nome_usuario_responsavel;
        this.perfil_responsavel = perfil_responsavel;
        this.conduta = conduta;
        this.olho_d = olho_d;
        this.olho_e = olho_e;
        this.parecer = parecer;
    }


    public int getId_historico_atendimento() {
        return id_historico_atendimento;
    }

    public void setId_historico_atendimento(int id_historico_atendimento) {
        this.id_historico_atendimento = id_historico_atendimento;
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public String getNome_usuario_solicitante() {
        return nome_usuario_solicitante;
    }

    public void setNome_usuario_solicitante(String nome_usuario_solicitante) {
        this.nome_usuario_solicitante = nome_usuario_solicitante;
    }

    public String getPerfil_solicitante() {
        return perfil_solicitante;
    }

    public void setPerfil_solicitante(String perfil_solicitante) {
        this.perfil_solicitante = perfil_solicitante;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getN_prontuario() {
        return n_prontuario;
    }

    public void setN_prontuario(String n_prontuario) {
        this.n_prontuario = n_prontuario;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public String getResumo_clinico() {
        return resumo_clinico;
    }

    public void setResumo_clinico(String resumo_clinico) {
        this.resumo_clinico = resumo_clinico;
    }

    public int getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(int id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public String getNome_usuario_responsavel() {
        return nome_usuario_responsavel;
    }

    public void setNome_usuario_responsavel(String nome_usuario_responsavel) {
        this.nome_usuario_responsavel = nome_usuario_responsavel;
    }

    public String getPerfil_responsavel() {
        return perfil_responsavel;
    }

    public void setPerfil_responsavel(String perfil_responsavel) {
        this.perfil_responsavel = perfil_responsavel;
    }

    public String getConduta() {
        return conduta;
    }

    public void setConduta(String conduta) {
        this.conduta = conduta;
    }

    public String getOlho_d() {
        return olho_d;
    }

    public void setOlho_d(String olho_d) {
        this.olho_d = olho_d;
    }

    public String getOlho_e() {
        return olho_e;
    }

    public void setOlho_e(String olho_e) {
        this.olho_e = olho_e;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }


    @Override
    public String toString() {
        return "ListarHistoricoAtendimento{" +
                "id_historico_atendimento=" + id_historico_atendimento +
                ", id_atendimento=" + id_atendimento +
                ", id_solicitante=" + id_solicitante +
                ", nome_usuario_solicitante='" + nome_usuario_solicitante + '\'' +
                ", perfil_solicitante='" + perfil_solicitante + '\'' +
                ", id_paciente=" + id_paciente +
                ", nome_paciente='" + nome_paciente + '\'' +
                ", n_prontuario='" + n_prontuario + '\'' +
                ", hospital='" + hospital + '\'' +
                ", andar='" + andar + '\'' +
                ", status='" + status + '\'' +
                ", leito='" + leito + '\'' +
                ", resumo_clinico='" + resumo_clinico + '\'' +
                ", id_responsavel=" + id_responsavel +
                ", nome_usuario_responsavel='" + nome_usuario_responsavel + '\'' +
                ", perfil_responsavel='" + perfil_responsavel + '\'' +
                ", conduta='" + conduta + '\'' +
                ", olho_d='" + olho_d + '\'' +
                ", olho_e='" + olho_e + '\'' +
                ", parecer='" + parecer + '\'' +
                '}';
    }
}
