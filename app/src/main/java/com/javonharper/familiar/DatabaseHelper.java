package com.javonharper.familiar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Familiar.db";

    private static DatabaseHelper instance = null;

    private static final java.lang.String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Habit.TABLE_NAME + " (" +
                    Habit._ID + " INTEGER PRIMARY KEY," +
                    Habit.COLUMN_NAME_NAME + " TEXT " +
                    ")";

    private static final java.lang.String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Habit.TABLE_NAME;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }

        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
