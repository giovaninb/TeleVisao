package br.edu.ufcspa.giovanib.televisao.controle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.modelo.EstadoAtendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarAtendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.ListarHistoricoAtendimento;


public class AdapterListaHistorico extends BaseAdapter {

    private final List<ListarHistoricoAtendimento> listarHistoricoAtendimentos;
    private final Activity act;

    public AdapterListaHistorico(List<ListarHistoricoAtendimento> listarHistoricoAtendimentos, Activity act) {
        this.listarHistoricoAtendimentos = listarHistoricoAtendimentos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return listarHistoricoAtendimentos.size();
    }

    @Override
    public Object getItem(int position) {
        return listarHistoricoAtendimentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_historico_listview, parent, false);
        ListarHistoricoAtendimento listarHistoricoAtendimento = listarHistoricoAtendimentos.get(position);

        //pegando as referencias da view
        ImageView imagem = (ImageView) view.findViewById(R.id.lista_hist_imagem);
        TextView nome = (TextView) view.findViewById(R.id.lista_hist_nomePac);
        TextView hospital = (TextView) view.findViewById(R.id.lista_hist_hospital);
        TextView responsavel = (TextView) view.findViewById(R.id.lista_hist_responsavel_atend);

        // TODO Corrigir estado de Atendimento
        EstadoAtendimento estadoAtendimento = EstadoAtendimento.FINALIZADO;

        if (estadoAtendimento.equals(EstadoAtendimento.DISPONIVEL)) {
            imagem.setImageResource(R.mipmap.ic_atend_disp);
        } else if (estadoAtendimento.equals(EstadoAtendimento.FAZENDO)) {
            imagem.setImageResource(R.mipmap.ic_atend_ocupado);
        } else if (estadoAtendimento.equals(EstadoAtendimento.FINALIZADO)) {
            imagem.setImageResource(R.mipmap.ic_atend_concluido);
        }
        //populando as Views
        nome.setText(listarHistoricoAtendimento.getNome_paciente());
        hospital.setText(listarHistoricoAtendimento.getHospital());
        responsavel.setText(listarHistoricoAtendimento.getNome_usuario_responsavel());

        return view;
    }
}
