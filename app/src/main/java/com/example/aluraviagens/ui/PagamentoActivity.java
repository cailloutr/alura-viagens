package com.example.aluraviagens.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity implements PacoteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(getString(R.string.app_bar_title_pagamento));

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        if (getIntent().hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            bindViews(pacote);
        }
    }

    private void bindViews(Pacote pacote) {
        mostraTextView(R.id.pagamento_activity_valor_da_compra, MoedaUtil.getFormatPrice(pacote));
        configuraBotao(pacote);
    }

    private void configuraBotao(Pacote pacote) {
        Button finalizarCompra = findViewById(R.id.pagamento_activity_finalizar_compra_button);
        finalizarCompra.setOnClickListener(v -> vaiParaResumoCompra(pacote));
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraTextView(int viewId, String string) {
        TextView view = findViewById(viewId);
        view.setText(string);
    }
}