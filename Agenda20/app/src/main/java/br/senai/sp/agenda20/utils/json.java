package br.senai.sp.agenda20.utils;

import org.json.JSONException;
import org.json.JSONStringer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.senai.sp.agenda20.model.Contato;

public class json {

    public static JSONStringer criarJson(Contato contato){

        JSONStringer jsonStringer = new JSONStringer();
        try {

            jsonStringer.object();//INICIANDO O API "{"
            jsonStringer.key("nome").value(contato.getNome().toString());
            jsonStringer.key("email").value(contato.getEmail().toString());
            jsonStringer.key("foto").value(contato.getFoto().toString());
            jsonStringer.key("telefone").value(contato.getTelefone().toString());
            jsonStringer.key("endereco").value(contato.getEndereco().toString());
            jsonStringer.key("linkedin").value(contato.getLinkedin().toString());
            jsonStringer.endObject();//fechando a api "}"

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonStringer;
    }


}
