package com.example.moneyplan7;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class AddCategoryIncomeFragment extends Fragment {
    private String[] colors = {"black", "white", "light_red", "brown_Orange", "lilac", "lilac_pink",
            "dark_blue", "blue", "light_blue", "green_blue", "light_green", "dark_green", "yellow"};
    Button button;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_category_income, container, false);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, colors);

        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        Spinner spinner = view.findViewById(R.id.spinner2);
        spinner.setAdapter(arrayAdapter);
        button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = view.findViewById(R.id.name_text);
                String name1 = name.getText().toString();
                boolean isExpense = false;
                String color = spinner.getSelectedItem().toString();
                dbHelper = new DBHelper(getActivity());
                db = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBHelper.COLUMN_NAME, name1);
                contentValues.put(DBHelper.COLUMN_EXPENSE, isExpense);
                contentValues.put(DBHelper.COLUMN_MONEY, 0);
                contentValues.put(DBHelper.COLUMN_COLOR, color);
                db.insert(DBHelper.TABLE_ACCOUNTS, null, contentValues);
                db.close();
                Toast.makeText(getActivity(), name1, Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}