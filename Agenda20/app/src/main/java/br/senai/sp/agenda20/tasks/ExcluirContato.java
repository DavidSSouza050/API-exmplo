package br.senai.sp.agenda20.tasks;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.senai.sp.agenda20.model.Contato;

public class ExcluirContato extends AsyncTask{
    private Contato contato;

    public ExcluirContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        try {

            // trazedo a url
            URL url = new URL("http://10.107.134.12:8080/contatos/"+ contato.getId());
            // atribuindo a conexao
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            //dizendo o tipo da conexao
            conexao.setRequestMethod("DELETE");
            //conectando com o banco
            conexao.connect();
            conexao.getInputStream();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;
    }
}
