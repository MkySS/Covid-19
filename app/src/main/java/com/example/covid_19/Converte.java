package com.example.covid_19;

import android.content.ContentValues;
import android.database.Cursor;

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
    public static ContentValues TipoToConverteValues(Tipo tipo){
        ContentValues valores = new ContentValues();

        valores.put(BDTableTipo.CAMPO_TIPO_NOME, tipo.getTipo());

        return valores;
    }

    public static Local cursorToLocal(Cursor cursor) {
        Local local = new Local();
        local.setId(cursor.getInt(cursor.getColumnIndex(BDTableLocal._ID)));
        local.setNome(cursor.getString(cursor.getColumnIndex(BDTableLocal.CAMPO_LOCAL_NOME)));
        local.setRua(cursor.getString(cursor.getColumnIndex(BDTableLocal.CAMPO_NOME_RUA)));
        local.setTipo(cursor.getString(cursor.getColumnIndex(BDTableLocal.CAMPO_TIPO)));
        local.setDistrito(cursor.getString(cursor.getColumnIndex(BDTableLocal.CAMPO_DISTRITO)));
        return local;
    }
}
