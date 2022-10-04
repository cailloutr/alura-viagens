package com.example.aluraviagens.util;

import com.example.aluraviagens.model.Pacote;

import java.text.NumberFormat;

public class MoedaUtil {

    public static String getFormatPrice(Pacote pacote) {
        return NumberFormat.getCurrencyInstance().format(pacote.getPreco());
    }
}
