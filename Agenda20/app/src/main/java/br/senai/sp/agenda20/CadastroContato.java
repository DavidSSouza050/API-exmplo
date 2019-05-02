package br.senai.sp.agenda20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.senai.sp.agenda20.model.Contato;
import br.senai.sp.agenda20.tasks.AtualizarContato;
import br.senai.sp.agenda20.tasks.GravarContato;

public class CadastroContato extends AppCompatActivity {
    private EditText txt_nome;
    private EditText txt_endereco;
    private EditText txt_telefone;
    private EditText txt_foto;
    private EditText txt_email;
    private EditText txt_linkedin;
    private Button btGravar;
    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);
        //atibuindo variaveis
        btGravar = findViewById(R.id.salva_contato);
        txt_nome = findViewById(R.id.nome__contato);
        txt_email = findViewById(R.id.email_contato);
        txt_endereco = findViewById(R.id.endereco_contato);
        txt_linkedin = findViewById(R.id.linkedin_contato);
        txt_telefone = findViewById(R.id.telefone__contato);
        txt_foto = findViewById(R.id.foto_contato);


        Intent intentPegarContato = getIntent();
        contato = (Contato) intentPegarContato.getSerializableExtra("contato");
        //verificando se o contato não é nulo para preencher as caixas e evitar erro
        if(contato != null){
            txt_nome.setText(contato.getNome());
            txt_email.setText(contato.getEmail());
            txt_endereco.setText(contato.getEndereco());
            txt_foto.setText(contato.getFoto());
            txt_linkedin.setText(contato.getLinkedin());
            txt_telefone.setText(contato.getTelefone());
        }


        btGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contato.setNome(txt_nome.getText().toString());
                contato.setEmail(txt_email.getText().toString());
                contato.setEndereco(txt_endereco.getText().toString());
                contato.setFoto(txt_foto.getText().toString());
                contato.setLinkedin(txt_linkedin.getText().toString());
                contato.setTelefone(txt_telefone.getText().toString());

                if(contato.getId() == 0){
                    GravarContato gravarContato = new GravarContato(contato);
                    gravarContato.execute();
                    finish();
                }else{
                    AtualizarContato atualizarContato = new AtualizarContato(contato);
                    atualizarContato.execute();
                    finish();
                }

            }
        });
    }
}
