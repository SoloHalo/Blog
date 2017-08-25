package com.cql.blog.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cql.blog.utils.ReflectUtil;

/**
 * Created by home on 2017/8/25.
 */

public abstract class BaseMvpActivity<P extends BasePrenster,M extends BaseModel> extends AppCompatActivity {

    public P getPresenter() {
        return mPresenter;
    }

    private P mPresenter;

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        mPresenter = ReflectUtil.getT(this, 0);
        if (mPresenter != null && this instanceof BaseView)
            //noinspection unchecked
            mPresenter.attach((BaseView) this, (BaseModel) ReflectUtil.getT(this,1));
        initView();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }

    @SuppressWarnings("unchecked")
    protected <T> T findView(@IdRes int id) {
        return (T) findViewById(id);
    }
}
