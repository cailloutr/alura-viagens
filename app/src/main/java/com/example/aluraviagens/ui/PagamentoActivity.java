package com.example.aluraviagens.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.ResumoCompraActivity;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(getString(R.string.app_bar_title_pagamento));

        Pacote pacote = new Pacote("São Paulo", "@drawable/sao_paulo_sp", 2, new BigDecimal("245.44"));

        bindViews(pacote);

        startActivity(new Intent(this, ResumoCompraActivity.class));
    }

    private void bindViews(Pacote pacote) {
        mostraTextView(R.id.pagamento_activity_valor_da_compra, MoedaUtil.getFormatPrice(pacote));
    }

    private void mostraTextView(int viewId, String string) {
        TextView view = findViewById(viewId);
        view.setText(string);
    }
}