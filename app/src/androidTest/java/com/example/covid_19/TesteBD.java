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

    private long insereSintoma(BDTableSintomas tableSintomas, Sintoma sintoma){
        long id = tableSintomas.insert(Converte.SintomaaToConverteValues(sintoma));
        assertNotEquals(-1, id);

        return id;
    }

    private long insereSintoma(BDTableSintomas tabelaSintomas, String nome_sintoma){
        Sintoma sintoma = new Sintoma();
        sintoma.setNome(nome_sintoma);

        return insereSintoma(tabelaSintomas, sintoma);
    }
    @Test
    public void consegueInserirSintoma(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableSintomas tabelaSintomas = new BDTableSintomas(bd);

        insereSintoma(tabelaSintomas, "Tosse");

        bd.close();
    }
    @Test
    public void conseguirLerSintoma(){
        Context appContext = getTargetContext();
        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BDTableSintomas tabelaSintomas = new BDTableSintomas(db);

        Cursor cursor = tabelaSintomas.query(BDTableSintomas.TODOS_CAMPOS_SINTOMAS, null,null,null,null, null);
        int registos = cursor.getCount();
        cursor.close();

        insereSintoma(tabelaSintomas, "Febre");

        cursor = tabelaSintomas.query(BDTableSintomas.TODOS_CAMPOS_SINTOMAS, null,null,null,null,null);
        assertEquals(registos + 1, cursor.getCount());
        cursor.close();

        db.close();
    }
    @Test
    public void consegueAlterarSintoma(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableSintomas tabelaSintomas = new BDTableSintomas(bd);

        Sintoma sintoma = new Sintoma();
        sintoma.setNome("Teste");

        long id = insereSintoma(tabelaSintomas, sintoma);

        sintoma.setNome("Dores Musculares");
        int registosAfetados = tabelaSintomas.update(Converte.SintomaaToConverteValues(sintoma), BDTableSintomas._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosAfetados);

        bd.close();
    }

    @Test
    public void consegueEliminarSintoma(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableSintomas tabelaSintoma = new BDTableSintomas(bd);

        long id = insereSintoma(tabelaSintoma, "Teste");

        int registosEliminados = tabelaSintoma.delete(BDTableSintomas._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosEliminados);

        bd.close();
    }
    private long insereLocal(SQLiteDatabase bd, String nome_local, String rua, String Nome_Regiao, String Nome_tipo){
        BDTableRegiao tabelaRegiao = new BDTableRegiao(bd);

        long idRegiao = insereRegiao(tabelaRegiao, Nome_Regiao);

        Local local = new Local();
        local.setNome(nome_local);
        local.setRua(rua);
        local.setId_regiao(idRegiao);
        local.setTipo(Nome_tipo);

        BDTableLocal tabelaLocal = new BDTableLocal(bd);
        long id = tabelaLocal.insert(Converte.localToContentValues(local));
        assertNotEquals(-1, id);

        return id;
    }

    @Test
    public void consegueInserirLocal(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        insereLocal(bd, "Hospital de S.Joao", "Alameda Prof. Hernâni Monteiro", "Porto", "Hospital");

        bd.close();
    }

    @Test
    public void consegueLerLocal(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        BDTableLocal tabelaLocal = new BDTableLocal(bd);

        Cursor cursor = tabelaLocal.query(BDTableLocal.TODOS_CAMPOS_LOCAL, null,null,null,null,null);
        int registos = cursor.getCount();
        cursor.close();

        insereLocal(bd, "Centro de Saude Serpa Pinto", "Rua de Serpa Pinto", "Porto", "Centro de saude");

        cursor = tabelaLocal.query(BDTableLocal.TODOS_CAMPOS_LOCAL, null,null,null,null,null);
        assertEquals(registos + 1, cursor.getCount());
        cursor.close();

        bd.close();
    }

    @Test
    public void consegueAlterarLocal(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        long idLocal = insereLocal(bd, "TESTE", "TESTE", "TESTE", "TESTE");

        BDTableLocal tabelaLocal = new BDTableLocal(bd);

        Cursor cursor = tabelaLocal.query(BDTableLocal.TODOS_CAMPOS_LOCAL, BDTableLocal.CAMPO_ID_COMPLETO + "=?", new String[]{ String.valueOf(idLocal) }, null,null,null);
        assertEquals(1, cursor.getCount());

        assertTrue(cursor.moveToNext());
        Local local = Converte.cursorToLocal(cursor);
        cursor.close();

        assertEquals("TESTE", local.getNome());

        local.setNome("Hospital Santo Antonio");
        int registosAfetados = tabelaLocal.update(Converte.localToContentValues(local), BDTableLocal.CAMPO_ID_COMPLETO + "=?", new String[]{String.valueOf(local.getId())});
        assertEquals(1, registosAfetados);

        bd.close();
    }

    @Test
    public void consegueEliminarLocal(){
        Context appContext = getTargetContext();

        BDCovidOpenHelper openHelper = new BDCovidOpenHelper(appContext);
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        long id = insereLocal(bd, "Hostipal Santo Antonio", "Largo do Prof. Abel Salazar", "Porto", "Hospital");

        BDTableLocal tabelaLocal = new BDTableLocal(bd);
        int registosEliminados = tabelaLocal.delete(BDTableLocal._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals(1, registosEliminados);

        bd.close();
    }
}
