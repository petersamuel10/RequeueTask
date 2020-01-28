package com.example.mytask;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask.model.Restaurant;

import java.util.List;

public class HomeBindingAdapter {

    @BindingAdapter("restaurantList")
    public static void setRestaurantList(RecyclerView restaurantRc, List<Restaurant> restaurantList) {

        if (restaurantList == null)
            return;

        RestaurantAdapter adapter = (RestaurantAdapter) restaurantRc.getAdapter();
        if (adapter == null) {
            adapter = new RestaurantAdapter(restaurantList);
            restaurantRc.setAdapter(adapter);
        }
    }
}
