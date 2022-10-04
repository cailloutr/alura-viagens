package com.example.aluraviagens.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.util.ResourceUtil;
import com.example.aluraviagens.util.StringUtil;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(position);
        Resources resources = context.getResources();

        configuraTextView(view, R.id.item_pacote_local, pacote.getLocal());

        configuraImageView(view, pacote, resources);

        configuraTextView(view, R.id.item_pacote_dias, StringUtil.getQuantityStringDias(pacote, resources));

        configuraTextView(view, R.id.item_pacote_preco, MoedaUtil.getFormatPrice(pacote));

        return view;
    }

    private void configuraImageView(View view, Pacote pacote, Resources resources) {
        ImageView pacoteImage = view.findViewById(R.id.item_pacote_image);
        int drawableId = ResourceUtil.getDrawable(context, pacote, resources);
        pacoteImage.setImageDrawable(resources.getDrawable(drawableId));
    }

    private void configuraTextView(View view, int item, String string) {
        TextView textView = view.findViewById(item);
        textView.setText(string);
    }
}
