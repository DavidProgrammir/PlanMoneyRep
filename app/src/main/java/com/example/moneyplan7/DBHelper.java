package com.example.moneyplan7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "moneyPlanN.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_CATEGORIES_INCOME = "categoriesIncome";
    public static final String COLUMN_MONEY = "money";
    public static final String COLUMN_EXPENSE = "expense";
    public static final String TABLE_CATEGORIES_EXPENSE = "categoriesExpense";
    public static final String TABLE_OPERATIONS = "operations";
    public static final String COLUMN_START_TRANSFER = "startTransfer";
    public static final String COLUMN_END_TRANSFER = "endTransfer";
    public static final String COLUMN_SUM = "sum";
    public static final String COLUMN_DATE = "date";
    public static final String TABLE_ACCOUNTS = "accounts";
    public static final String COLUMN_COLOR = "color";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CASHLESS = "cashless";
    public static final String COLUMN_BALANCE = "balance";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_CATEGORIES_INCOME + "(_id integer PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_COLOR + " text, "
                + COLUMN_NAME + " text, "
                + COLUMN_MONEY + " integer, "
                + COLUMN_EXPENSE + " integer);";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE_CATEGORIES_EXPENSE + "(_id integer PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_COLOR + " text, "
                + COLUMN_NAME + " text, "
                + COLUMN_MONEY + " integer, "
                + COLUMN_EXPENSE + " integer);";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE_OPERATIONS + "(_id integer PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_START_TRANSFER + " text, "
                + COLUMN_END_TRANSFER + " text, "
                + COLUMN_EXPENSE + " integer, "
                + COLUMN_SUM + " text, "
                + COLUMN_DATE + " text);";
        db.execSQL(query);
        query = "CREATE TABLE " + TABLE_ACCOUNTS + "(_id integer PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " text UNIQUE,"
                + COLUMN_CASHLESS + " integer, "
                + COLUMN_BALANCE + " integer, "
                + COLUMN_COLOR + " text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
