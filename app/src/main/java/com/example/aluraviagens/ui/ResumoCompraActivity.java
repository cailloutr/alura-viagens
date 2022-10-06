package com.example.aluraviagens.ui;

import android.annotation.SuppressLint;
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

public class ResumoCompraActivity extends AppCompatActivity implements PacoteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(getString(R.string.app_bar_title_resumo_da_compra));

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        if (getIntent().hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);
            bindViews(pacote);
        }
    }

    private void bindViews(Pacote pacote) {
        mostraImagem(R.id.resumo_compra_pacote_image, getResources(), pacote);

        mostraTextView(R.id.resumo_compra_pacote_local, pacote.getLocal());

        mostraTextView(
                R.id.resumo_compra_pacote_periodo,
                DataUtil.getPeriodoString(pacote, getResources())
        );

        mostraTextView(R.id.resumo_compra_pacote_price, MoedaUtil.getFormatPrice(pacote));
    }

    private void mostraTextView(int viewId, String string) {
        TextView view = findViewById(viewId);
        view.setText(string);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void mostraImagem(int viewId, Resources resources, Pacote pacote) {
        ImageView view = findViewById(viewId);
        view.setImageDrawable(
                resources.getDrawable(ResourceUtil.getDrawable(this, pacote, resources))
        );
    }
}