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
        regiao.setDistrito("Teste");

        long id = insereRegiao(tabelaRegiao, regiao);

        regiao.setDistrito("Viseu");
        int registosAfetados = tabelaRegiao.update(Converte.DistritoToConverteValues(regiao), BDTableRegiao._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosAfetados);

        bd.close();
    }

    @Test
    public void consegueEliminarRegiao(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableRegiao tabelaRegiao = new BDTableRegiao(bd);

        long id = insereRegiao(tabelaRegiao, "Teste");

        int registosEliminados = tabelaRegiao.delete(BDTableRegiao._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosEliminados);

        bd.close();
    }
    private long insereDC(BDTableDC tabelaDC, Doenca_Cronica dc){
        long id = tabelaDC.insert(Converte.DCToConverteValues(dc));
        assertNotEquals(-1, id);

        return id;
    }

    private long insereDC(BDTableDC tabelaDC, String nome_dc){
        Doenca_Cronica DC = new Doenca_Cronica();
        DC.setNome(nome_dc);

        return insereDC(tabelaDC, DC);
    }
    @Test
    public void consegueInserirDC(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableDC tabelaDC = new BDTableDC(bd);

        insereDC(tabelaDC, "diabetes");

        bd.close();
    }
    @Test
    public void conseguirLerDC(){
        Context appContext = getTargetContext();
        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BDTableDC tabelaDC = new BDTableDC(db);

        Cursor cursor = tabelaDC.query(BDTableDC.TODOS_CAMPOS_DC, null,null,null,null, null);
        int registos = cursor.getCount();
        cursor.close();

        insereDC(tabelaDC, "doença oncologica");

        cursor = tabelaDC.query(BDTableDC.TODOS_CAMPOS_DC, null,null,null,null,null);
        assertEquals(registos + 1, cursor.getCount());
        cursor.close();

        db.close();
    }
    @Test
    public void consegueAlterarDC(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableDC tabelaDC = new BDTableDC(bd);

        Doenca_Cronica DC= new Doenca_Cronica();
        DC.setNome("Teste");

        long id = insereDC(tabelaDC, DC);

        DC.setNome("hipertensão arterial");
        int registosAfetados = tabelaDC.update(Converte.DCToConverteValues(DC), BDTableDC._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosAfetados);

        bd.close();
    }

    @Test
    public void consegueEliminarDC(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableDC tabelaDC = new BDTableDC(bd);

        long id = insereDC(tabelaDC, "Teste");

        int registosEliminados = tabelaDC.delete(BDTableDC._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosEliminados);

        bd.close();
    }
    private long insereTipo(BDTableTipo tableTipo, Tipo tipo){
        long id = tableTipo.insert(Converte.TipoToConverteValues(tipo));
        assertNotEquals(-1, id);

        return id;
    }

    private long insereTipo(BDTableTipo tabelaTipo, String nome_tipo){
        Tipo tipo = new Tipo();
        tipo.setTipo(nome_tipo);

        return insereTipo(tabelaTipo, tipo);
    }
    @Test
    public void consegueInserirTipo(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableTipo tabelaTipo = new BDTableTipo(bd);

        insereTipo(tabelaTipo, "Hospital");

        bd.close();
    }
    @Test
    public void conseguirLerTipo(){
        Context appContext = getTargetContext();
        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BDTableTipo tabelaTipo = new BDTableTipo(db);

        Cursor cursor = tabelaTipo.query(BDTableTipo.TODOS_CAMPOS_TIPO, null,null,null,null, null);
        int registos = cursor.getCount();
        cursor.close();

        insereTipo(tabelaTipo, "Centro de Saude");

        cursor = tabelaTipo.query(BDTableTipo.TODOS_CAMPOS_TIPO, null,null,null,null,null);
        assertEquals(registos + 1, cursor.getCount());
        cursor.close();

        db.close();
    }
    @Test
    public void consegueAlterarTipo(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableTipo tabelaTipo = new BDTableTipo(bd);

        Tipo tipo = new Tipo();
        tipo.setTipo("Teste");

        long id = insereTipo(tabelaTipo, tipo);

        tipo.setTipo("Fármacia");
        int registosAfetados = tabelaTipo.update(Converte.TipoToConverteValues(tipo), BDTableTipo._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosAfetados);

        bd.close();
    }

    @Test
    public void consegueEliminarTipo(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableTipo tabelaTipo = new BDTableTipo(bd);

        long id = insereTipo(tabelaTipo, "Teste");

        int registosEliminados = tabelaTipo.delete(BDTableTipo._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosEliminados);

        bd.close();
    }
}
