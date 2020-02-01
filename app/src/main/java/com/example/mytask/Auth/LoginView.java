package com.example.mytask.Auth;


import com.example.mytask.base.BaseView;
import com.example.mytask.model.User;

public interface LoginView extends BaseView {

    void handleLogin(User user);
}
