package com.example.mytask.mainPage.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytask.model.Category;

import java.util.List;

public class HomeBindingAdapter {

    @BindingAdapter("categoryList")
    public static void setCategoryList(RecyclerView categoryRc, List<Category> categoryList) {

        if (categoryList == null)
            return;

        RestaurantAdapter adapter = (RestaurantAdapter) categoryRc.getAdapter();
        if (adapter == null) {
            adapter = new RestaurantAdapter(categoryList);
            categoryRc.setAdapter(adapter);
        }
    }
}
