package com.example.mytask.mainPage.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask.R;
import com.example.mytask.databinding.ItemCategoryBinding;
import com.example.mytask.model.Category;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Category> restaurantList;

    RestaurantAdapter(List<Category> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding categoryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_category, parent, false);
        return new ViewHolder(categoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categoryBinding.setCategory(restaurantList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding categoryBinding;

        ViewHolder(@NonNull ItemCategoryBinding itemView) {
            super(itemView.getRoot());
            this.categoryBinding = itemView;

        }
    }
}
