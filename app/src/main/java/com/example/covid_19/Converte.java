package com.example.covid_19;

import android.content.ContentValues;

public class Converte {
    public static ContentValues SintomaaToConverteValues(Sintoma sintoma){
        ContentValues valores = new ContentValues();

        valores.put(BDTableSintomas.CAMPO_NOME, sintoma.getNome());

        return valores;
    }
    public static ContentValues DCToConverteValues(Doenca_Cronica DC){
        ContentValues valores = new ContentValues();

        valores.put(BDTableDC.CAMPO_NOME_DC, DC.getNome());

        return valores;
    }
    public static ContentValues DistritoToConverteValues(Regiao Distrito){
        ContentValues valores = new ContentValues();

        valores.put(BDTableRegiao.CAMPO_NOME_DISTRITO, Distrito.getDistrito());

        return valores;
    }
}
