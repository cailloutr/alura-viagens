package com.example.aluraviagens.ui;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.adapter.ListaPacotesAdapter;
import com.example.aluraviagens.model.Pacote;

import java.util.List;

import br.com.alura.aluraviagens.dao.PacoteDAO;

public class ListaDePacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_pacotes);

        setTitle(getString(R.string.app_bar_title));
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_de_pacotes_listview);
        List<Pacote> lista = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(lista, this));
    }
}