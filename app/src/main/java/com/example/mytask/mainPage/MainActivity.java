package com.example.mytask.mainPage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.databinding.DataBindingUtil;

import com.example.mytask.R;
import com.example.mytask.base.BaseActivity;
import com.example.mytask.databinding.ActivityMainBinding;
import com.example.mytask.model.Category;
import com.example.mytask.model.Level;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity implements HomeView {

    private ActivityMainBinding mainBinding;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Restaurants");
        Level level = new Level(0);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new HomePresenter();
        presenter.attachView(this);
        presenter.getCategoryList(level);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    @Override
    public void getProductList(HashMap<String, List<Category>> categoryList) {
        mainBinding.setCategories(categoryList.get("category_item"));
    }
}
