package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by icaromsc on 20/06/2017.
 */

public class ListarAtendimento {

   /* {"id_atendimento":"10","id_solicitante":"3",
            "id_paciente":"5","hospital":"Hospital Santa Clara","andar":"9",
            "status":"P","leito":"666","resumo_clinico":"my preciouss",
            "nome_usuario_solicitante":"administrador do sistema ","perfil":"A",
            "nome_paciente":"fibonacci","n_prontuario":"42"}]*/

    private int id_atendimento;
    private int id_solicitante;
    private int id_paciente;
    private String hospital;
    private String andar;
    private String leito;
    private String resumo_clinico;
    private String nome_usuario_solicitante;
    private String perfil;
    private String nome_paciente;
    private String n_prontuario;


    public ListarAtendimento(int id_atendimento, int id_solicitante, int id_paciente, String hospital,
                             String andar, String leito, String resumo_clinico, String nome_usuario_solicitante,
                             String perfil, String nome_paciente, String n_prontuario) {
        this.id_atendimento = id_atendimento;
        this.id_solicitante = id_solicitante;
        this.id_paciente = id_paciente;
        this.hospital = hospital;
        this.andar = andar;
        this.leito = leito;
        this.resumo_clinico = resumo_clinico;
        this.nome_usuario_solicitante = nome_usuario_solicitante;
        this.perfil = perfil;
        this.nome_paciente = nome_paciente;
        this.n_prontuario = n_prontuario;
    }

    @Override
    public String toString() {
        return "ListarAtendimento{" +
                "id_atendimento=" + id_atendimento +
                ", id_solicitante=" + id_solicitante +
                ", id_paciente=" + id_paciente +
                ", hospital='" + hospital + '\'' +
                ", andar='" + andar + '\'' +
                ", leito='" + leito + '\'' +
                ", resumo_clinico='" + resumo_clinico + '\'' +
                ", nome_usuario_solicitante='" + nome_usuario_solicitante + '\'' +
                ", perfil='" + perfil + '\'' +
                ", nome_paciente='" + nome_paciente + '\'' +
                ", n_prontuario='" + n_prontuario + '\'' +
                '}';
    }
}
