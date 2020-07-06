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

    public static ContentValues localToContentValues(Local local){
        ContentValues valores = new ContentValues();

        valores.put(BDTableLocal.ID_REGIAO, local.getId_regiao());
        valores.put(BDTableLocal.ID_TIPO, local.getId_tipo());
        valores.put(BDTableLocal.CAMPO_LOCAL_NOME, local.getNome());
        valores.put(BDTableLocal.CAMPO_NOME_RUA, local.getRua());

        return valores;
    }
    public static Local contentValuesToLocal(ContentValues valores){
        Local local = new Local();

        local.setId(valores.getAsLong(BDTableLocal._ID));
        local.setNome(valores.getAsString(BDTableLocal.CAMPO_LOCAL_NOME));
        local.setRua(valores.getAsString(BDTableLocal.CAMPO_NOME_RUA));
        local.setId_tipo(valores.getAsInteger(BDTableLocal.ID_TIPO));
        local.setId_regiao(valores.getAsInteger(BDTableLocal.ID_REGIAO));

        return local;
    }

    public static Local cursorToLocal(Cursor cursor) {
        Local local = new Local();
        local.setId(cursor.getInt(cursor.getColumnIndex(BDTableLocal._ID)));
        local.setNome(cursor.getString(cursor.getColumnIndex(BDTableLocal.CAMPO_LOCAL_NOME)));
        local.setRua(cursor.getString(cursor.getColumnIndex(BDTableLocal.CAMPO_NOME_RUA)));
        local.setId_regiao(cursor.getInt(cursor.getColumnIndex(BDTableLocal.ID_REGIAO)));
        local.setId_tipo(cursor.getInt(cursor.getColumnIndex(BDTableLocal.ID_TIPO)));
        return local;
    }
}
