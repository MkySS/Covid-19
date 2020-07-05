package com.example.covid_19;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDCovidOpenHelper extends SQLiteOpenHelper {
    public static final String NOME_BASE_DADOS = "Covid.db";
    public static final int VERSAO_BASE_DADOS = 1;
    private static final boolean DESENVOLVIMENTO = true;
    private final Context context;


    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public BDCovidOpenHelper(@Nullable Context context) {
        super(context, NOME_BASE_DADOS, null, VERSAO_BASE_DADOS);
        this.context = context;
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        BDTableSintomas tabelaSintomas = new BDTableSintomas(db);
        tabelaSintomas.cria();

        BDTableDC tabelaDC = new BDTableDC(db);
        tabelaDC.cria();

        BDTableRegiao tabelaRegiao = new BDTableRegiao(db);
        tabelaRegiao.cria();

        BDTableTipo tabelaTipo = new BDTableTipo(db);
        tabelaTipo.cria();

        BDTableLocal tabelaLocal = new BDTableLocal(db);
        tabelaLocal.cria();

        PreencheTabelaSintomas(tabelaSintomas);

        PreencheTabelaDC(tabelaDC);

        PreencheTabelaRegiao(tabelaRegiao);

        PrencheTabelaTipo(tabelaTipo);

        if(DESENVOLVIMENTO){
            seedData(db);
        }
    }

    private void seedData(SQLiteDatabase db){
        /*BDTableSintomas tabelaSintomas = new BDTableSintomas(db);

        Sintoma sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s1));
        long idSinS1 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s2));
        long idSinS2 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s3));
        long idSinS3 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s4));
        long idSinS4 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s5));
        long idSinS5 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s6));
        long idSinS6 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s7));
        long idSinS7 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s8));
        long idSinS8 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s9));
        long idSinS9 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));*/

    }
    public void PreencheTabelaSintomas(BDTableSintomas tabelaSintomas){

        Sintoma sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s1));
        long idSinS1 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s2));
        long idSinS2 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s3));
        long idSinS3 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s4));
        long idSinS4 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s5));
        long idSinS5 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s6));
        long idSinS6 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s7));
        long idSinS7 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s8));
        long idSinS8 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

        sintoma = new Sintoma();
        sintoma.setNome(context.getString(R.string.s9));
        long idSinS9 = tabelaSintomas.insert(Converte.SintomaaToConverteValues(sintoma));

    }
    public void PreencheTabelaDC(BDTableDC tabelaDC){

        Doenca_Cronica DC = new Doenca_Cronica();
        DC.setNome(context.getString(R.string.DC1));
        long idDoenDC1 = tabelaDC.insert(Converte.DCToConverteValues(DC));

        DC = new Doenca_Cronica();
        DC.setNome(context.getString(R.string.DC2));
        long idDoenDC2 = tabelaDC.insert(Converte.DCToConverteValues(DC));

        DC = new Doenca_Cronica();
        DC.setNome(context.getString(R.string.DC3));
        long idDoenDC3 = tabelaDC.insert(Converte.DCToConverteValues(DC));

        DC = new Doenca_Cronica();
        DC.setNome(context.getString(R.string.DC4));
        long idDoenDC4 = tabelaDC.insert(Converte.DCToConverteValues(DC));

        DC = new Doenca_Cronica();
        DC.setNome(context.getString(R.string.DC5));
        long idDoenDC5 = tabelaDC.insert(Converte.DCToConverteValues(DC));

    }

    public void PreencheTabelaRegiao(BDTableRegiao tabelaRegiao){

        Regiao Distrito = new Regiao();
        Distrito.setDistrito("Aveiro");
        long idDist1 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Beja");
        long idDist2 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Braga");
        long idDist3 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Bragança");
        long idDist4 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Castelo Branco");
        long idDist5 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Coimbra");
        long idDist6 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Évora");
        long idDist7 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Faro");
        long idDist8 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Guarda");
        long idDist9 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Leiria");
        long idDist10 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Lisboa");
        long idDist11 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Portalegre");
        long idDist12 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Porto");
        long idDist13 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Santarém");
        long idDist14 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Setúbal");
        long idDist15 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Viana do Castelo");
        long idDist16 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Vila Real");
        long idDist17 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));

        Distrito = new Regiao();
        Distrito.setDistrito("Viseu");
        long idDist18 = tabelaRegiao.insert(Converte.DistritoToConverteValues(Distrito));
    }

    private void PrencheTabelaTipo(BDTableTipo tabelaTipo){

        Tipo tipo = new Tipo();
        tipo.setTipo("Hospital");
        long idTip1 = tabelaTipo.insert(Converte.TipoToConverteValues(tipo));

        tipo = new Tipo();
        tipo.setTipo("Centro de Saude");
        long idTip2 = tabelaTipo.insert(Converte.TipoToConverteValues(tipo));

        tipo = new Tipo();
        tipo.setTipo("Fármacia");
        long idTip3 = tabelaTipo.insert(Converte.TipoToConverteValues(tipo));

        tipo = new Tipo();
        tipo.setTipo("Centro de Rastreio Móvel");
        long idTip4 = tabelaTipo.insert(Converte.TipoToConverteValues(tipo));
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
