package com.example.moneyplan7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AddFragment extends Fragment {

    Button btn1, btn2, btn3, btn4, btn5;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        btn1 = view.findViewById(R.id.add1);
        btn2 = view.findViewById(R.id.add2);
        btn3 = view.findViewById(R.id.add3);
        btn4 = view.findViewById(R.id.add4);
        btn5 = view.findViewById(R.id.add5);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCategoryIncomeFragment addCategoryIncomeFragment = new AddCategoryIncomeFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, addCategoryIncomeFragment);
                fragmentTransaction.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCategoryExpenseFragment addCategoryExpenseFragment = new AddCategoryExpenseFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, addCategoryExpenseFragment);
                fragmentTransaction.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddIncomeFragment addIncomeFragment = new AddIncomeFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, addIncomeFragment);
                fragmentTransaction.commit();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddExpenceFragment addExpenceFragment = new AddExpenceFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, addExpenceFragment);
                fragmentTransaction.commit();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAccountFragment addAccountFragment = new AddAccountFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, addAccountFragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}