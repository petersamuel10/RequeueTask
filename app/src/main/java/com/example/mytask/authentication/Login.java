package com.example.mytask.authentication;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;

import com.example.mytask.mainPage.MainActivity;
import com.example.mytask.R;
import com.example.mytask.base.BaseActivity;
import com.example.mytask.model.User;
import com.google.android.material.button.MaterialButton;

public class Login extends BaseActivity implements LoginView {

    private AppCompatEditText email_ed, password_ed;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_ed = findViewById(R.id.email_ed);
        password_ed = findViewById(R.id.password_ed);
        MaterialButton loginBtn = findViewById(R.id.login_btn);
        presenter = new LoginPresenter();
        presenter.attachView(this);

        loginBtn.setOnClickListener(view ->
                presenter.login(email_ed.getText().toString(), password_ed.getText().toString())
        );
    }

    @Override
    public void handleLogin(User user) {
        if (user != null)
            start(MainActivity.class);
    }
}
