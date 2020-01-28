package com.example.mytask.Util;

import android.graphics.Color;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class GlideBinding {

    // image view with url or bitmap
    @BindingAdapter("photo")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .placeholder(Color.WHITE)
                .into(imageView);
    }
}
