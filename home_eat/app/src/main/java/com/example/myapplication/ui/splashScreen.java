package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.ui.login.logIn;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_login_splash)
    public void login_btn_clicked() {
        startActivity(new Intent(splashScreen.this, logIn.class));
        finish();
    }

    @OnClick(R.id.btn_signup_splash)
    public void signup_btn_clicked() {
        startActivity(new Intent(splashScreen.this, SignUp_page1.class));
        finish();
    }


}
