package com.example.moneyplan7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class AccountsFragment extends Fragment {

    private ArrayList<Account> accounts = new ArrayList<Account>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initializeData() {
        DBHelper dbHelper = new DBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query;
        query = "SELECT COUNT(_id) FROM " + DBHelper.TABLE_ACCOUNTS + ";";   //"SELECT * FROM " + DBHelper.TABLE_ACCOUNTS + ";";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int length = cursor.getInt(0);
        cursor.close();
        Cursor cursor2;
        query = "SELECT * FROM " + DBHelper.TABLE_ACCOUNTS + ";";
        cursor2 = db.rawQuery(query, null);
        boolean cashless;
        cursor2.moveToFirst();
        Log.i("length", ""+length);
        for (int i = 0; i < length; i++) {
            int k = cursor2.getColumnIndex(DBHelper.COLUMN_CASHLESS);
            if (k < 0) {
                Toast.makeText(getActivity(), "Eror", Toast.LENGTH_SHORT).show();
            } else {
            int isCashless = cursor2.getInt(k);
            if (isCashless > 0) {
                cashless = true;
            } else {
                cashless = false;

            }
            accounts.add(new Account(cursor2.getString(1), cashless, cursor2.getInt(3), "" ));
            cursor2.moveToNext();}
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_accounts, container, false);
        initializeData();
        RecyclerView recView = view.findViewById(R.id.accounts_recView);
        AccountAdapter accountAdapter = new AccountAdapter(getActivity(), accounts);
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recView.setAdapter(accountAdapter);

        return view;
    }
}