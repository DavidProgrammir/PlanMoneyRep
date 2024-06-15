package com.example.moneyplan7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    RecyclerView historyRecView;
    private ArrayList<Transfer> transfers = new ArrayList<Transfer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initializeData() {
        transfers.add(new Transfer("card1", "машина", true, "400000", "19.04.24"));
        transfers.add(new Transfer("card1", "еда", true, "1500", "11.02.24"));
        transfers.add(new Transfer("бизнес", "card2", false, "60", "13.03.24"));
        transfers.add(new Transfer("card1", "развлечения", true, "3000", "23.06.24"));
        transfers.add(new Transfer("cash", "строительство", true, "10000", "30.04.24"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        historyRecView = view.findViewById(R.id.history_recyclerview);
        initializeData();
        HistoryAdapter historyAdapter = new HistoryAdapter(getActivity(), transfers);
        historyRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        historyRecView.setAdapter(historyAdapter);
        return view;
    }
}