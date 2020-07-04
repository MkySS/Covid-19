package com.example.covid_19;

import android.content.ContentValues;

public class Converte {
    public static ContentValues SintomaaToConverteValues(Sintoma sintoma){
        ContentValues valores = new ContentValues();

        valores.put(BDTableSintomas.CAMPO_NOME, sintoma.getNome());

        return valores;
    }
}
