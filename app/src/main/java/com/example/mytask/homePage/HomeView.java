package com.example.mytask.homePage;

import com.example.mytask.base.BaseView;
import com.example.mytask.model.Category;

import java.util.HashMap;
import java.util.List;

public interface HomeView extends BaseView {

    void getProductList(HashMap<String, List<Category>> categoryList);
}
