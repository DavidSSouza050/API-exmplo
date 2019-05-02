package br.senai.sp.agenda20.tasks;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.senai.sp.agenda20.model.Contato;

public class AtualizarContato extends AsyncTask {
    private Contato contato;

    public AtualizarContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        JSONStringer jsContato = new JSONStringer();
        try {

            jsContato.object();//INICIANDO O API "{"
            jsContato.key("id").value(contato.getId());
            jsContato.key("nome").value(contato.getNome().toString());
            jsContato.key("email").value(contato.getEmail().toString());
            jsContato.key("foto").value(contato.getFoto().toString());
            jsContato.key("telefone").value(contato.getTelefone().toString());
            jsContato.key("endereco").value(contato.getEndereco().toString());
            jsContato.key("linkedin").value(contato.getLinkedin().toString());
            jsContato.endObject();//fechando a api "}"

            // trazedo a url
            URL url = new URL("http://10.107.134.12:8080/contatos/" + contato.getId());
            // atribuindo a conexao
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            //dizendo o top de requisicao
            conexao.setRequestProperty("Content-type", "application/json");
            // dizendo que aceita o retorno e json
            conexao.setRequestProperty("Accept", "application/json/");
            //dizendo o tipo da conexao
            conexao.setRequestMethod("PUT");
            //dizendo que vou "fazer" uma entrada no servidor
            //a partir da conexão
            conexao.setDoInput(true);

            // criando o fluxa de saída, levando um Json
            PrintStream output = new PrintStream(conexao.getOutputStream());
            output.print(jsContato);

            //conectando com o banco
            conexao.connect();

            Scanner scanner = new Scanner(conexao.getInputStream());
            String resposta = scanner.nextLine();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
