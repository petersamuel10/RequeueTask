package com.example.mytask.mainPage;

import com.example.mytask.base.BasePresenter;
import com.example.mytask.model.Category;
import com.example.mytask.model.Level;
import com.example.mytask.service.APIManager;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter extends BasePresenter<HomeView> {

    void getCategoryList() {
        getView().showProgress();

        Level level = new Level(0);
        APIManager.getInstance().getAPI().categoryList(level)
                .enqueue(new Callback<HashMap<String, List<Category>>>() {
                    @Override
                    public void onResponse(Call<HashMap<String, List<Category>>> call, Response<HashMap<String, List<Category>>> response) {
                        getView().hideProgress();
                        getView().getProductList(response.body());
                    }

                    @Override
                    public void onFailure(Call<HashMap<String, List<Category>>> call, Throwable t) {
                        getView().hideProgress();
                        getView().showMessage(t.getMessage());
                    }
                });
    }
}
