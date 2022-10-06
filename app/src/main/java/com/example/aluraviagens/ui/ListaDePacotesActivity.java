package com.example.aluraviagens.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.adapter.ListaPacotesAdapter;
import com.example.aluraviagens.dao.PacoteDAO;
import com.example.aluraviagens.model.Pacote;

import java.util.List;

public class ListaDePacotesActivity extends AppCompatActivity implements PacoteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_pacotes);

        setTitle(getString(R.string.app_bar_title));
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_de_pacotes_listview);
        final List<Pacote> lista = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(lista, this));
        listaDePacotes.setOnItemClickListener((parent, view, position, id) -> vaiParaResumoPacote(position, lista));
    }

    private void vaiParaResumoPacote(int position, List<Pacote> lista) {
        Intent intent = new Intent(ListaDePacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, lista.get(position));
        startActivity(intent);
    }
}