package com.example.mytask.homePage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;

import com.example.mytask.R;
import com.example.mytask.base.BaseActivity;
import com.example.mytask.databinding.ActivityMainBinding;
import com.example.mytask.model.Category;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity implements HomeView {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(mainBinding.myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setStatusBarGradient(this);

        HomePresenter presenter = new HomePresenter();
        presenter.attachView(this);

        presenter.getCategoryList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradient(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(R.drawable.purple_gradient);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }

    @Override
    public void getProductList(HashMap<String, List<Category>> categoryList) {
        mainBinding.setCategories(categoryList.get("category_item"));
    }
}
