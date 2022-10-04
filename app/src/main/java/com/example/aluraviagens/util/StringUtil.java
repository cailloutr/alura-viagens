package com.example.aluraviagens.util;

import android.content.res.Resources;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;

public class StringUtil {

    public static String getQuantityStringDias(Pacote pacote, Resources resources) {
        return resources.getQuantityString(
                R.plurals.plural_dia,
                pacote.getDias(),
                pacote.getDias());
    }
}
