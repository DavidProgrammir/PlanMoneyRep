package com.example.moneyplan7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonHome, buttonHistory, buttonAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickHome(View view) {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteiner, homeFragment);
        fragmentTransaction.commit();
    }
    public void onClickHistory(View view) {
        HistoryFragment historyFragment = new HistoryFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteiner, historyFragment);
        fragmentTransaction.commit();
    }
    public void onClickAccounts(View view) {
        AccountsFragment accountsFragment = new AccountsFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteiner, accountsFragment);
        fragmentTransaction.commit();
    }

    public void onClickAdd(View view) {
        AddFragment addFragment = new AddFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.conteiner, addFragment);
        fragmentTransaction.commit();
    }


}