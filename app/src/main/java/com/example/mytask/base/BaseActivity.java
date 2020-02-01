package com.example.mytask.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytask.Util.ProgressDialog;

public class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void start(Class<? extends BaseActivity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public void showProgress() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideProgress() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
