package com.cql.blog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cql.blog.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginActivity.startActivity(this);
    }
}
