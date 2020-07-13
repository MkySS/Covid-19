package com.example.covid_19;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentProviderLocal extends android.content.ContentProvider{
    private static final String AUTHORITY = "com.example.covid_19";
    private static final String LOCAL = "local";
    private static final String REGIAO = "Regiao";
    private static final String SINTOMAS = "sintomas";
    private static final String DOENCA_CRONICA = "DC";

    private static final Uri ENDERECO_BASE = Uri.parse("content://" + AUTHORITY);
    public static final Uri ENDERECO_LOCAL = Uri.withAppendedPath(ENDERECO_BASE, LOCAL);
    public static final Uri ENDERECO_REGIAO = Uri.withAppendedPath(ENDERECO_BASE, REGIAO);
    public static final Uri ENDERECO_SINTOMAS = Uri.withAppendedPath(ENDERECO_BASE, SINTOMAS);
    public static final Uri ENDERECO_DOENCA_CRONICA = Uri.withAppendedPath(ENDERECO_BASE, DOENCA_CRONICA);

    private static final int URI_LOCAL = 100;
    private static final int URI_ID_LOCAL = 101;

    private static final int URI_REGIAO = 200;
    private static final int URI_ID_REGIAO = 201;

    private static final int URI_SINTOMAS = 300;
    private static final int URI_ID_SINTOMAS = 301;

    private static final int URI_DOENCA_CRONICA = 400;
    private static final int URI_ID_DOENCA_CRONICA = 401;

    private static final String CURSOR_DIR = "vnd.android.cursor.dir/";
    private static final String CURSOR_ITEM = "vnd.android.cursor.item/";

    private BDCovidOpenHelper openHelper;

    private UriMatcher getUriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(AUTHORITY, LOCAL, URI_LOCAL);
        uriMatcher.addURI(AUTHORITY, LOCAL + "/#", URI_ID_LOCAL);

        uriMatcher.addURI(AUTHORITY, REGIAO, URI_REGIAO);
        uriMatcher.addURI(AUTHORITY, REGIAO + "/#", URI_ID_REGIAO);

        uriMatcher.addURI(AUTHORITY, SINTOMAS, URI_SINTOMAS);
        uriMatcher.addURI(AUTHORITY, SINTOMAS + "/#", URI_ID_SINTOMAS);

        uriMatcher.addURI(AUTHORITY, DOENCA_CRONICA, URI_DOENCA_CRONICA);
        uriMatcher.addURI(AUTHORITY, DOENCA_CRONICA + "/#", URI_ID_DOENCA_CRONICA);

        return uriMatcher;

    }

    @Override
    public boolean onCreate() {
        openHelper = new BDCovidOpenHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase bd = openHelper.getReadableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)){
            case URI_LOCAL:
                return new BDTableLocal(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_ID_LOCAL:
                return new BDTableLocal(bd).query(projection, BDTableLocal._ID + "=?", new String[]{ id }, null, null, sortOrder);

            case URI_REGIAO:
                return new BDTableRegiao(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_ID_REGIAO:
                return new BDTableRegiao(bd).query(projection, BDTableRegiao._ID + "=?", new String[]{ id }, null, null, sortOrder);

            case URI_SINTOMAS:
                return new BDTableSintomas(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_ID_SINTOMAS:
                return new BDTableSintomas(bd).query(projection, BDTableSintomas._ID + "=?", new String[]{ id }, null, null, sortOrder);

            case URI_DOENCA_CRONICA:
                return new BDTableDC(bd).query(projection, selection, selectionArgs, null, null, sortOrder);

            case URI_ID_DOENCA_CRONICA:
                return new BDTableDC(bd).query(projection, BDTableDC._ID + "=?", new String[] { id }, null, null, sortOrder);

            default:
                throw new UnsupportedOperationException("Endereço de query inválido: " + uri.getPath());
        }
    }

    /**
     * Implement this to handle requests for the MIME type of the data at the
     * given URI.  The returned MIME type should start with
     * <code>vnd.android.cursor.item</code> for a single record,
     * or <code>vnd.android.cursor.dir/</code> for multiple items.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * <p>Note that there are no permissions needed for an application to
     * access this information; if your content provider requires read and/or
     * write permissions, or is not exported, all applications can still call
     * this method regardless of their access permissions.  This allows them
     * to retrieve the MIME type for a URI when dispatching intents.
     *
     * @param uri the URI to query.
     * @return a MIME type string, or {@code null} if there is no type.
     */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int codigoUri = getUriMatcher().match(uri);

        switch (codigoUri){
            case URI_LOCAL:
                return CURSOR_DIR + LOCAL;
            case URI_ID_LOCAL:
                return CURSOR_ITEM + LOCAL;
            case URI_REGIAO:
                return CURSOR_DIR + REGIAO;
            case URI_ID_REGIAO:
                return CURSOR_ITEM + REGIAO;
            case URI_SINTOMAS:
                return CURSOR_DIR + SINTOMAS;
            case URI_ID_SINTOMAS:
                return CURSOR_ITEM + SINTOMAS;
            case URI_DOENCA_CRONICA:
                return CURSOR_DIR + DOENCA_CRONICA;
            case URI_ID_DOENCA_CRONICA:
                return CURSOR_ITEM + DOENCA_CRONICA;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        long id;

        switch (getUriMatcher().match(uri)){
            case URI_LOCAL:
                id = (new BDTableLocal(bd).insert(values));
                break;

            case URI_REGIAO:
                id = (new BDTableRegiao(bd).insert(values));
                break;

            case URI_SINTOMAS:
                id = (new BDTableSintomas(bd).insert(values));
                break;

            case URI_DOENCA_CRONICA:
                id = (new BDTableDC(bd).insert(values));
                break;

            default:
                throw new UnsupportedOperationException("Endereço inser inválido: " + uri.getPath());
        }
        if (id == -1){
            throw new SQLException("Não foi possivel inserir o registo: " + uri.getPath());
        }
        return Uri.withAppendedPath(uri, String.valueOf(id));
    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)){
            case URI_ID_LOCAL:
                return new BDTableLocal(bd).delete(BDTableLocal._ID + "=?", new String[]{id});

            case URI_ID_REGIAO:
                return new BDTableRegiao(bd).delete(BDTableRegiao._ID + "=?", new String[]{ id });

            case URI_ID_SINTOMAS:
                return new BDTableSintomas(bd).delete(BDTableSintomas._ID + "=?", new String[]{ id });

            case URI_ID_DOENCA_CRONICA:
                return new BDTableDC(bd).delete(BDTableDC._ID + "=?", new String[]{ id });

            default:
                throw new UnsupportedOperationException("Endereço delete inválido: " + uri.getPath());
        }
    }
    
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase bd = openHelper.getWritableDatabase();

        String id = uri.getLastPathSegment();

        switch (getUriMatcher().match(uri)){
            case URI_ID_LOCAL:
                return new BDTableLocal(bd).update(values, BDTableLocal._ID + "=?", new String[]{ id });

            case URI_ID_REGIAO:
                return new BDTableRegiao(bd).update(values, BDTableRegiao._ID + "=?", new String[] { id });

            case URI_ID_SINTOMAS:
                return new BDTableSintomas(bd).update(values, BDTableSintomas._ID + "=?", new String[] { id });

            case URI_ID_DOENCA_CRONICA:
                return new BDTableDC(bd).update(values, BDTableDC._ID + "=?", new String[] { id });

            default:
                throw new UnsupportedOperationException("Endereço de update inválido: " + uri.getPath());
        }
    }
}
