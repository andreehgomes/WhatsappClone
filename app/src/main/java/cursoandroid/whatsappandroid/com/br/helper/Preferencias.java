package cursoandroid.whatsappandroid.com.br.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "whatsApp.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private String CHAVE_IDENTIFCADOR = "identificadorUsuarioLogado";
    private String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context contextoParametro){

        contexto = contextoParametro;
        preferences  = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();


    }

    public void salvarDados( String identificadorUsuario, String nomeUsuario){

        editor.putString( CHAVE_IDENTIFCADOR, identificadorUsuario);
        editor.putString( CHAVE_NOME, nomeUsuario);

        editor.commit();

    }


    public String getIdentificador(){

        return preferences.getString(CHAVE_IDENTIFCADOR, null);
    }

    public String getNome(){

        return preferences.getString(CHAVE_NOME, null);
    }



}
