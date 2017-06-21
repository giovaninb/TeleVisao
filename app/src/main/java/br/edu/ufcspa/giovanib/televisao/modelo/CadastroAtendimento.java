package br.edu.ufcspa.giovanib.televisao.modelo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by icaromsc on 19/06/2017.
 *
 *
 * DAO para comunicar com web service no cadastro de atendimento
 *
 *
 *  OBS: atributos do objeto devem ter o mesmo nome que os campos JSON
 *
 *
 */

public class CadastroAtendimento {

    private int id_solicitante;
    private String nome_paciente;
    private String n_prontuario;
    private String hospital;
    private String andar;
    private String leito;
    private String resumo_clinico;

    public CadastroAtendimento(int id_solicitante, String nome_paciente, String n_prontuario, String hospital, String andar, String leito, String resumo_clinico) {
        this.id_solicitante = id_solicitante;
        this.nome_paciente = nome_paciente;
        this.n_prontuario = n_prontuario;
        this.hospital = hospital;
        this.andar = andar;
        this.leito = leito;
        this.resumo_clinico = resumo_clinico;
    }


    public int getId_usuario_solicitante() {
        return id_solicitante;
    }

    public void setId_usuario_solicitante(int id_usuario_solicitante) {
        this.id_solicitante = id_usuario_solicitante;
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


    @Override
    public String toString() {
        return "CadastroAtendimento{" +
                "id_usuario_solicitante=" + id_solicitante +
                ", nome_paciente='" + nome_paciente + '\'' +
                ", n_prontuario='" + n_prontuario + '\'' +
                ", hospital='" + hospital + '\'' +
                ", andar='" + andar + '\'' +
                ", leito='" + leito + '\'' +
                ", resumo_clinico='" + resumo_clinico + '\'' +
                '}';
    }
}
