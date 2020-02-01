package com.example.mytask.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mytask.R;
import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {

    private MaterialButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn);


    }
}
