package com.cql.blog.login;

import com.cql.blog.base.BaseModel;
import com.cql.blog.base.BasePrenster;
import com.cql.blog.base.BaseView;
import com.cql.blog.model.OAuth;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by home on 2017/8/25.
 */

public interface LoginContract {
    abstract class Prenster extends BasePrenster<View,Model>{
        abstract void doLogin();
    }

    interface View extends BaseView{
        void loginFail(String msg);
        void loginSuccess();

        String getUsername();
        String getPassword();
    }

    interface Model extends BaseModel{
        Observable<OAuth> login(String username, String password);
    }
}
