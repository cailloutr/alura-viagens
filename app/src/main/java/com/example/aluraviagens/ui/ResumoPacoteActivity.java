package com.example.aluraviagens.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.DataUtil;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.util.ResourceUtil;
import com.example.aluraviagens.util.StringUtil;

import java.math.BigDecimal;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(getString(R.string.app_bar_title_resumo_do_pacote_activity));

        Pacote pacote = new Pacote("São Paulo", "@drawable/sao_paulo_sp", 2, new BigDecimal("245.44"));

        bindViews(pacote);

    }

    private void bindViews(Pacote pacote) {
        Resources resources = this.getResources();

        // Imagem
        mostraImagem(R.id.resumo_pacote_imageView, resources, pacote);

        // Local
        mostraTextView(R.id.resumo_pacote_textview_cidade, pacote.getLocal());

        // Dias
        mostraTextView(
                R.id.resumo_pacote_textview_dias,
                StringUtil.getQuantityStringDias(pacote, resources));

        // Preço
        mostraTextView(R.id.resumo_pacote_price, MoedaUtil.getFormatPrice(pacote));

        // Período
        mostraTextView(
                R.id.resumo_pacote_textview_periodo,
                DataUtil.getPeriodoString(pacote, resources)
        );

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
    }


    private void mostraTextView(int viewId, String string) {
        TextView view = findViewById(viewId);
        view.setText(string);
    }

    private void mostraImagem(int viewId, Resources resources, Pacote pacote) {
        ImageView view = findViewById(viewId);
        view.setImageDrawable(
                resources.getDrawable(ResourceUtil.getDrawable(this, pacote, resources))
        );
    }

}


