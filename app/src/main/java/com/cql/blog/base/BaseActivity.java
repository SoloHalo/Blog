package com.cql.blog.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by CQL on 2017/8/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
