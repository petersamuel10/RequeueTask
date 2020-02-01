package com.example.mytask;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mytask.databinding.ActivityMainBinding;
import com.example.mytask.model.Category;
import com.example.mytask.model.Level;
import com.example.mytask.service.APIManager;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Restaurants");
        final ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Level level = new Level(0);

        APIManager.getInstance().getAPI().categoryList(level)
                .enqueue(new Callback<HashMap<String, List<Category>>>() {
                    @Override
                    public void onResponse(Call<HashMap<String, List<Category>>> call, Response<HashMap<String, List<Category>>> response) {
                        mainBinding.setCategories((response.body()).get("category_item"));
                    }

                    @Override
                    public void onFailure(Call<HashMap<String, List<Category>>> call, Throwable t) {
                        Log.d("result", t.getMessage());
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar_menu, menu);
        return true;
    }
}
