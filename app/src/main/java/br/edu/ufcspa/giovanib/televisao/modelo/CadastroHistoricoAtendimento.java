package br.edu.ufcspa.giovanib.televisao.modelo;

/**
 * Created by icaromsc on 24/06/2017.
 */

public class CadastroHistoricoAtendimento {

    private int id_atendimento;
    private int id_responsavel;
    private String conduta;
    private String parecer;
    private String olho_d;
    private String olho_e;

    public CadastroHistoricoAtendimento(int id_atendimento, int id_responsavel, String conduta, String parecer, String olho_d, String olho_e) {
        this.id_atendimento = id_atendimento;
        this.id_responsavel = id_responsavel;
        this.conduta = conduta;
        this.parecer = parecer;
        this.olho_d = olho_d;
        this.olho_e = olho_e;
    }


    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public int getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(int id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public String getConduta() {
        return conduta;
    }

    public void setConduta(String conduta) {
        this.conduta = conduta;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
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


    @Override
    public String toString() {
        return "CadastroHistoricoAtendimento{" +
                "id_atendimento=" + id_atendimento +
                ", id_responsavel=" + id_responsavel +
                ", conduta='" + conduta + '\'' +
                ", parecer='" + parecer + '\'' +
                ", olho_d='" + olho_d + '\'' +
                ", olho_e='" + olho_e + '\'' +
                '}';
    }



}
