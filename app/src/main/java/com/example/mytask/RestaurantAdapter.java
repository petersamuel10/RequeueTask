package com.example.mytask;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask.databinding.ItemCardBinding;
import com.example.mytask.model.Restaurant;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurant> restaurantList;

    RestaurantAdapter(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardBinding itemCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_card, parent, false);
        return new ViewHolder(itemCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemCardBinding.setRestaurant(restaurantList.get(position));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemCardBinding itemCardBinding;

        ViewHolder(@NonNull ItemCardBinding itemView) {
            super(itemView.getRoot());
            this.itemCardBinding = itemView;

        }
    }
}
