package cursoandroid.whatsappandroid.com.br.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


import cursoandroid.whatsappandroid.com.br.R;
import cursoandroid.whatsappandroid.com.br.helper.Preferencias;
import cursoandroid.whatsappandroid.com.br.model.Mensagem;


public class MensagemAdapter extends ArrayAdapter<Mensagem> {

    private Context context;
    private ArrayList<Mensagem> mensagens;

    public MensagemAdapter(Context c, ArrayList<Mensagem> objects) {
        super(c, 0, objects);
        this.context = c;
        this.mensagens = objects;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View view = null;

        //verifica se a lista está preenchida
        if ( mensagens != null ){

            //Recupera dados do usuario remetente
            Preferencias preferencias = new Preferencias(context);
            String idUsuarioRemetente = preferencias.getIdentificador();


            //inicializar objeto para montagem do layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //Recupera mensagem
            Mensagem mensagem = mensagens.get(position);

            //Montar view a partir do xml
            if( idUsuarioRemetente.equals( mensagem.getIdUsuario() ) ){
                view = inflater.inflate(R.layout.item_mensagem_direita, parent, false);
            }else{
                view = inflater.inflate(R.layout.item_mensagem_esquerda, parent, false);
            }


            //recupera elemento para exibição
            TextView textoMensagem = (TextView) view.findViewById(R.id.tv_mensagem);
            textoMensagem.setText( mensagem.getMensagem() );

        }


        return view;
    }
}
