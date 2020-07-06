package com.example.covid_19;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TesteBD {
    @Before
    @Test
    public void apagarBaseDados(){
        getTargetContext().deleteDatabase(BDCovidOpenHelper.NOME_BASE_DADOS);
    }
    @Test
    public void conseguirAbrirBaseDados(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getReadableDatabase();
        assertTrue(bd.isOpen());
        bd.close();
    }
    private Context getTargetContext() {
        return InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    private long insereRegiao(BDTableRegiao tableRegiao, Regiao regiao){
        long id = tableRegiao.insert(Converte.DistritoToConverteValues(regiao));
        assertNotEquals(-1, id);

        return id;
    }

    private long insereRegiao(BDTableRegiao tabelaRegiao, String nome_distrito){
        Regiao regiao = new Regiao();
        regiao.setDistrito(nome_distrito);

        return insereRegiao(tabelaRegiao, regiao);
    }
    @Test
    public void consegueInserirRegiao(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableRegiao tabelaRegiao = new BDTableRegiao(bd);

        insereRegiao(tabelaRegiao, "Porto");

        bd.close();
    }
    @Test
    public void conseguirLerRegiao(){
        Context appContext = getTargetContext();
        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BDTableRegiao tabelaRegiao = new BDTableRegiao(db);

        Cursor cursor = tabelaRegiao.query(BDTableRegiao.TODOS_CAMPOS_REGIAO, null,null,null,null, null);
        int registos = cursor.getCount();
        cursor.close();

        insereRegiao(tabelaRegiao, "Guarda");

        cursor = tabelaRegiao.query(BDTableRegiao.TODOS_CAMPOS_REGIAO, null,null,null,null,null);
        assertEquals(registos + 1, cursor.getCount());
        cursor.close();

        db.close();
    }
    @Test
    public void consegueAlterarRegiao(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableRegiao tabelaRegiao = new BDTableRegiao(bd);

        Regiao regiao = new Regiao();
        regiao.setDistrito("Franc");

        long id = insereRegiao(tabelaRegiao, regiao);

        regiao.setDistrito("Viseu");
        int registosAfetados = tabelaRegiao.update(Converte.DistritoToConverteValues(regiao), BDTableRegiao._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosAfetados);

        bd.close();
    }

    @Test
    public void consegueEliminarPaises(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableRegiao tabelaPaises = new BDTableRegiao(bd);

        long id = insereRegiao(tabelaPaises, "Teste");

        int registosEliminados = tabelaPaises.delete(BDTableRegiao._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosEliminados);

        bd.close();
    }
}
