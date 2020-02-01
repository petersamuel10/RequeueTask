package com.example.mytask.authentication;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.DataBindingUtil;

import com.example.mytask.R;
import com.example.mytask.Util.StringValidation;
import com.example.mytask.base.BaseActivity;
import com.example.mytask.databinding.ActivityLoginBinding;
import com.example.mytask.homePage.MainActivity;
import com.example.mytask.model.User;
import com.google.android.material.button.MaterialButton;

public class Login extends BaseActivity implements LoginView {

    private ActivityLoginBinding loginBinding;
    private AppCompatEditText email_ed, password_ed;
    private LoginPresenter presenter;
    private String emailStr, passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        email_ed = findViewById(R.id.email_ed);
        password_ed = findViewById(R.id.password_ed);
        MaterialButton loginBtn = findViewById(R.id.login_btn);
        presenter = new LoginPresenter();
        presenter.attachView(this);

        loginBtn.setOnClickListener(view -> {
            emailStr = email_ed.getText().toString();
            passwordStr = password_ed.getText().toString();
            if (isValidInput())
                presenter.login(email_ed.getText().toString(), password_ed.getText().toString());
        });
    }

    private boolean isValidInput() {
        if (!StringValidation.isEmailValid(emailStr)) {
            loginBinding.errorTxt.setText("Enter a valid email address");
            return false;
        }
        if (!StringValidation.isPasswordValid(passwordStr)) {
            loginBinding.errorTxt.setText("Password Length should be greater than 5");
            return false;
        }
        return true;
    }

    @Override
    public void handleLogin(User user) {
        if (user != null)
            start(MainActivity.class);
    }
}
