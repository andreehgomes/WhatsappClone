package cursoandroid.whatsappandroid.com.br.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


import cursoandroid.whatsappandroid.com.br.R;
import cursoandroid.whatsappandroid.com.br.model.Contato;

public class ContatoAdapter extends ArrayAdapter<Contato> {

    private ArrayList<Contato> contatos;
    private Context context;

    public ContatoAdapter(Context c, ArrayList<Contato> objects) {
        super(c, 0, objects);
        this.contatos = objects;
        this.context = c;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        View view = null;

        //Verifica se a lista está vazia
        if(contatos != null){
            //inicializar o objeto para a montagem da view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


            //Montar a view a partir do XML
            view = inflater.inflate(R.layout.lista_contato, parent, false);

            //recupera elemento para exibição
            TextView nomeContato = (TextView) view.findViewById(R.id.tv_nome);
            TextView emailContato = (TextView) view.findViewById(R.id.tv_email);


            Contato contato = contatos.get(position);
            nomeContato.setText(contato.getNome());
            emailContato.setText(contato.getEmail());
        }

        return view;

    }
}
