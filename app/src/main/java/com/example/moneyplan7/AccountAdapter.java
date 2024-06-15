package com.example.moneyplan7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Account> accounts;

    AccountAdapter(Context context, List<Account> accounts)  {
        this.accounts = accounts;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.accounts_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Account account = accounts.get(position);
        holder.name.setText(account.getName());
        holder.money.setText(account.getBalance() + "p");
        if (account.isCashless()) {
            holder.image.setImageResource(R.drawable.baseline_credit_card_24);
        } else  {
            holder.image.setImageResource(R.drawable.baseline_money_24);
        }
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, money;
        ImageView image;
        boolean cashless;
        String color;

        public ViewHolder(View view) {
            super(view);


            name = view.findViewById(R.id.accont_name_text);
            money = view.findViewById(R.id.accounts_money_text);
            image = view.findViewById(R.id.account_image);
        }
    }

}
