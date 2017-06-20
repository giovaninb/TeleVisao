package br.edu.ufcspa.giovanib.televisao.controle;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcspa.giovanib.televisao.R;
import br.edu.ufcspa.giovanib.televisao.modelo.Atendimento;
import br.edu.ufcspa.giovanib.televisao.modelo.EstadoAtendimento;

/**
 * Created by gnbettoni on 29/05/17.
 */

public class AdapterListaAtend extends BaseAdapter {

    private final List<Atendimento> atendimentos;
    private final Activity act;

    public AdapterListaAtend(List<Atendimento> atendimentos, Activity act) {
        this.atendimentos = atendimentos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return atendimentos.size();
    }

    @Override
    public Object getItem(int position) {
        return atendimentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_atend_listview, parent, false);
        Atendimento atendimento = atendimentos.get(position);

        //pegando as referencias da view
        ImageView imagem = (ImageView) view.findViewById(R.id.lista_atend_imagem);
        TextView nome = (TextView) view.findViewById(R.id.lista_atend_nomePac);
        TextView hospital = (TextView) view.findViewById(R.id.lista_atend_hospital);
        TextView descricao = (TextView) view.findViewById(R.id.lista_atend_descricao);

        EstadoAtendimento estadoAtendimento = atendimento.getEstadoAtendimento();

        if (estadoAtendimento.equals(EstadoAtendimento.DISPONIVEL)) {
            imagem.setImageResource(R.mipmap.ic_atend_disp);
        } else if (estadoAtendimento.equals(EstadoAtendimento.FAZENDO)) {
            //imagem.setImageResource(R.mipmap.ic_atend_ocupado);
        } else if (estadoAtendimento.equals(EstadoAtendimento.FINALIZADO)) {
            imagem.setImageResource(R.mipmap.ic_atend_concluido);
        }
        //populando as Views
        nome.setText(atendimento.getNomePaciente());
        hospital.setText(atendimento.getHospital());
        descricao.setText(atendimento.getDescricao());

        return view;
    }
}
