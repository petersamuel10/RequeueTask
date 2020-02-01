package com.example.mytask.Util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class GlideBinding {

    // image view with url or bitmap
    @BindingAdapter("photo")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load("https://assets.villa-vanillaa.com"+imageUrl)
                .placeholder(new ColorDrawable(Color.parseColor("#f6f6f6")))
                .into(imageView);
    }
}
