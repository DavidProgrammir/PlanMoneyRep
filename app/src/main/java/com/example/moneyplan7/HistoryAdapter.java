package com.example.moneyplan7;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Transfer> transfers;

    HistoryAdapter(Context context, List<Transfer> transfers) {
        this.transfers = transfers;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.history_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transfer transfer = transfers.get(position);
        holder.startTransfer.setText(transfer.getStartTransfer());
        holder.endTransfer.setText(transfer.getEndTransfer());
        if (transfer.isExpense()) {
            holder.sum.setText("-" + transfer.getSum() + "p");
            holder.sum.setTextColor(Color.RED);
        } else {
            holder.sum.setText("+" + transfer.getSum() + "p");
            holder.sum.setTextColor(Color.GREEN);
        }
        holder.date.setText(transfer.getDate());
    }

    @Override
    public int getItemCount() {
        return transfers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView startTransfer, endTransfer, sum, date;
        boolean expense;
        public ViewHolder(View view) {
            super(view);

            startTransfer = view.findViewById(R.id.text_start_transfer);
            endTransfer = view.findViewById(R.id.text_end_transfer);
            sum = view.findViewById(R.id.sum_transfer_text);
            date = view.findViewById(R.id.text_date);
        }
    }
}
