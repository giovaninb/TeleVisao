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
import br.edu.ufcspa.giovanib.televisao.modelo.EstadoUsuario;
import br.edu.ufcspa.giovanib.televisao.modelo.Usuario;

/**
 * Created by gnbettoni on 29/05/17.
 */

public class AdapterListaUsuario extends BaseAdapter {

    private final List<Usuario> usuarios;
    private final Activity act;

    public AdapterListaUsuario(List<Usuario> usuarios, Activity act) {
        this.usuarios = usuarios;
        this.act = act;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_atend_listview, parent, false);
        Usuario usuario = usuarios.get(position);

        //pegando as referencias da view
        ImageView imagem = (ImageView) view.findViewById(R.id.lista_atend_imagem);
        TextView nome = (TextView) view.findViewById(R.id.lista_atend_nomePac);


        EstadoUsuario estadoUsuario = usuario.getEstadoUsuario();

        if (estadoUsuario.equals(EstadoUsuario.ONLINE)) {
            imagem.setImageResource(R.drawable.ic_user_online);
        } else if (estadoUsuario.equals(EstadoUsuario.OCUPADO)) {
            imagem.setImageResource(R.drawable.ic_user_ocupado);
        } else if (estadoUsuario.equals(EstadoUsuario.AUSENTE)) {
            imagem.setImageResource(R.drawable.ic_user_ausente);
        } else if (estadoUsuario.equals(EstadoUsuario.OFFLINE)) {
            imagem.setImageResource(R.drawable.ic_user_offline);
        }


        //populando as Views
        nome.setText(usuario.getNomeUsuario());


        return view;
    }
}
