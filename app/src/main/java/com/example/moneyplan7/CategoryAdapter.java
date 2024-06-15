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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Category> categories;


    CategoryAdapter(Context context, List<Category> categories) {
        this.categories = categories;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.category_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.name.setText(category.getName());
        if (category.isExpense()) {
            holder.money.setText("-" + category.getMoney() + "p");
        } else {
            holder.money.setText("+" + category.getMoney() + "p");
        }
        holder.constraintLayout.setBackgroundColor(Color.parseColor(category.getColor()));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, money;
        ConstraintLayout constraintLayout;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.category_name_text);
            money = view.findViewById(R.id.category_money_text);
            constraintLayout = view.findViewById(R.id.category_item_layout);
        }
    }
}
