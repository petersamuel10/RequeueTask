package com.example.mytask.service;

import com.example.mytask.model.Category;
import com.example.mytask.model.Level;
import com.example.mytask.model.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIFunctions {

    @FormUrlEncoded
    @POST("LoginUser.php")
    Call<User> login(@Field("user_name") String email, @Field("user_password") String password);

    @POST("GetCategory.php")
    Call<HashMap<String,List<Category>>> categoryList(@Body Level level);

}
