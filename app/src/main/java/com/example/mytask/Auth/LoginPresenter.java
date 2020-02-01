package com.example.mytask.Auth;

import com.example.mytask.base.BasePresenter;
import com.example.mytask.model.User;
import com.example.mytask.service.APIManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LoginPresenter extends BasePresenter<LoginView> {

    void login(String email, String password) {

        getView().showProgress();
        APIManager.getInstance().getAPI().login("peter@gmail.com", "admin")
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        getView().hideProgress();
                        getView().handleLogin(response.body());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        getView().hideProgress();
                        getView().showMessage(t.getMessage());
                    }
                });

    }
}
