package com.example.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;

import com.example.aluraviagens.model.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static int getDrawable(Context context, Pacote pacote, Resources resources) {
        return resources.getIdentifier(
                pacote.getImagem(),
                DRAWABLE,
                context.getPackageName());
    }
}
