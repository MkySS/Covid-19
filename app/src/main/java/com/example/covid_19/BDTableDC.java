package com.example.covid_19;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BDTableDC implements BaseColumns{
    public static final String NOME_TABELA_DC = "DC";
    public static final String CAMPO_DOENCA_CRONICA = "DCN";

    public static final String CAMPO_ID_COMPLETO = NOME_TABELA_DC + "." + _ID;
    public static final String CAMPO_NOME_DOENCA_CRONICA = NOME_TABELA_DC + "." + CAMPO_DOENCA_CRONICA;

    public static final String[] TODOS_CAMPOS_DC = {CAMPO_ID_COMPLETO, CAMPO_NOME_DOENCA_CRONICA};

    private SQLiteDatabase db;

    public BDTableDC(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA_DC + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        CAMPO_DOENCA_CRONICA + " TEXT NOT NULL" +
                        ")"
        );
    }

    /**
     * Convenience method for inserting a row into the database.
     *
     * @param values this map contains the initial column values for the
     *            row. The keys should be the column names and the values the
     *            column values
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    public long insert(ContentValues values) {
        return db.insert(NOME_TABELA_DC, null, values);
    }

    /**
     * Query the given table, returning a {@link Cursor} over the result set.
     *
     * @param columns A list of which columns to return. Passing null will
     *            return all columns, which is discouraged to prevent reading
     *            data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an
     *            SQL WHERE clause (excluding the WHERE itself). Passing null
     *            will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be
     *         replaced by the values from selectionArgs, in order that they
     *         appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL
     *            GROUP BY clause (excluding the GROUP BY itself). Passing null
     *            will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor,
     *            if row grouping is being used, formatted as an SQL HAVING
     *            clause (excluding the HAVING itself). Passing null will cause
     *            all row groups to be included, and is required when row
     *            grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
     *            (excluding the ORDER BY itself). Passing null will use the
     *            default sort order, which may be unordered.
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     * @see Cursor
     */
    public Cursor query(String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        return db.query(NOME_TABELA_DC, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    /**
     * Convenience method for updating rows in the database.
     *
     * @param values a map from column names to new column values. null is a
     *            valid value that will be translated to NULL.
     * @param whereClause the optional WHERE clause to apply when updating.
     *            Passing null will update all rows.
     * @param whereArgs You may include ?s in the where clause, which
     *            will be replaced by the values from whereArgs. The values
     *            will be bound as Strings.
     * @return the number of rows affected
     */
    public int update(ContentValues values, String whereClause, String[] whereArgs) {
        return db.update(NOME_TABELA_DC, values, whereClause, whereArgs);
    }

    /**
     * Convenience method for deleting rows in the database.
     *
     * @param whereClause the optional WHERE clause to apply when deleting.
     *            Passing null will delete all rows.
     * @param whereArgs You may include ?s in the where clause, which
     *            will be replaced by the values from whereArgs. The values
     *            will be bound as Strings.
     * @return the number of rows affected if a whereClause is passed in, 0
     *         otherwise. To remove all rows and get a count pass "1" as the
     *         whereClause.
     */
    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(NOME_TABELA_DC, whereClause, whereArgs);
    }
}
