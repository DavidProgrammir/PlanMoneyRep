package com.example.moneyplan7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddExpenceFragment extends Fragment {
    DBHelper dbHelper;
    SQLiteDatabase db;




    public ArrayList<String> getAccounts() {
        ArrayList<String> accounts = new ArrayList<String>();
        DBHelper dbHelper = new DBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query;
        query = "SELECT COUNT(_id) FROM " + DBHelper.TABLE_CATEGORIES_EXPENSE + ";";   //"SELECT * FROM " + DBHelper.TABLE_ACCOUNTS + ";";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int length = cursor.getInt(0);
        cursor.close();
        Cursor cursor2;
        query = "SELECT * FROM " + DBHelper.TABLE_CATEGORIES_EXPENSE + ";";
        cursor2 = db.rawQuery(query, null);
        boolean cashless;
        cursor2.moveToFirst();
        Log.i("length", ""+length);
        for (int i = 0; i < length; i++) {
            int k = cursor2.getColumnIndex(DBHelper.COLUMN_NAME);
            if (k < 0) {
                Toast.makeText(getActivity(), "Eror", Toast.LENGTH_SHORT).show();
            } else {
                accounts.add(cursor2.getString(k).toString());
                cursor2.moveToNext();
            }
        }return accounts;}


    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<String>();
        DBHelper dbHelper = new DBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query;
        query = "SELECT COUNT(_id) FROM " + DBHelper.TABLE_CATEGORIES_EXPENSE + ";";   //"SELECT * FROM " + DBHelper.TABLE_ACCOUNTS + ";";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int length = cursor.getInt(0);
        cursor.close();
        Cursor cursor2;
        query = "SELECT * FROM " + DBHelper.TABLE_CATEGORIES_EXPENSE + ";";
        cursor2 = db.rawQuery(query, null);
        boolean cashless;
        cursor2.moveToFirst();
        Log.i("length", ""+length);
        for (int i = 0; i < length; i++) {
            int k = cursor2.getColumnIndex(DBHelper.COLUMN_NAME);
            if (k < 0) {
                Toast.makeText(getActivity(), "Eror", Toast.LENGTH_SHORT).show();
            } else {
                categories.add(cursor2.getString(k).toString());
                cursor2.moveToNext();
            }
        }return categories;}



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_expence, container, false);
        Spinner spinnerAccount = view.findViewById(R.id.spinner_account_expense);
        Spinner spinnerCategory = view.findViewById(R.id.spinner_category_expense);
        EditText editText = view.findViewById(R.id.editText_add_expense);
        ArrayList<String> accounts = getAccounts();
        ArrayList<String> categories = getCategories();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, accounts);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, categories);
        arrayAdapter.setDropDownViewResource
                (com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource
                (com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinnerAccount.setAdapter(arrayAdapter);
        spinnerCategory.setAdapter(arrayAdapter2);


        return view;
    }



    @Override
    public void onStop() {
        super.onStop();
    }
}