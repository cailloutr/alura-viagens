package com.example.aluraviagens.util;

import android.content.res.Resources;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataUtil {

    public static String getPeriodoString(Pacote pacote, Resources resources) {

        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacote.getDias());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM", Locale.US);
        String dataIdaFormatada = simpleDateFormat.format(dataIda.getTime());
        String dataVoltaFormatada = simpleDateFormat.format(dataVolta.getTime());

        return resources.getString(
                R.string.formato_perido_pacote,
                dataIdaFormatada,
                dataVoltaFormatada,
                String.valueOf(dataVolta.get(Calendar.YEAR))
        );
    }
}
