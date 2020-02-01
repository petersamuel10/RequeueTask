package com.example.mytask.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static APIManager mInstance;
    private Retrofit mRetrofit;

    private APIManager() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {

                    Request request = chain.request();
                    Request.Builder builder = request.newBuilder()
                            .addHeader("Cache-Control", "application/json");

                    Request newRequest = builder.build();

                    return chain.proceed(newRequest);
                }).build();


        String baseUrl = "http://app.villa-vanillaa.com/api/";
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

    }

    public static APIManager getInstance() {
        if (mInstance == null) {
            mInstance = new APIManager();
        }
        return mInstance;
    }

    public APIFunctions getAPI() {
        return mRetrofit.create(APIFunctions.class);
    }
}
