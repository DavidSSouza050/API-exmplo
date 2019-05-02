package br.senai.sp.agenda20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import br.senai.sp.agenda20.model.Contato;
import br.senai.sp.agenda20.tasks.CarregarListaContatos;
import br.senai.sp.agenda20.tasks.ExcluirContato;

public class MainActivity extends AppCompatActivity {

    public static ListView listViewContatos;
    public Button btNovoContato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContatos = findViewById(R.id.main_lista_contatos);
        btNovoContato = findViewById(R.id.bt_novo_conto);


        registerForContextMenu(listViewContatos);


        btNovoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContato = new Intent(MainActivity.this, CadastroContato.class);
                startActivity(intentContato);
            }
        });

        listViewContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contato = (Contato) listViewContatos.getItemAtPosition(position);
                Intent intentEditar = new Intent(MainActivity.this, CadastroContato.class);
                intentEditar.putExtra("contato", contato);
                startActivity(intentEditar);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        CarregarListaContatos carregarListaContatos = new CarregarListaContatos(this);
        carregarListaContatos.execute();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        final MenuItem excluir = menu.add("Excluir");

        excluir.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Contato contato = (Contato) listViewContatos.getItemAtPosition(info.position);
                ExcluirContato excluirContato = new ExcluirContato(contato);
                excluirContato.execute();
                onResume();
                return false;
            }
        });
    }

}