package com.example.mytask.service;

import com.example.mytask.model.Category;
import com.example.mytask.model.Level;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIFunctions {

    @POST("GetCategory.php")
    Call<HashMap<String,List<Category>>> categoryList(@Body Level level);
}
