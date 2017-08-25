package com.cql.blog.login;

import com.cql.blog.model.OAuth;
import com.cql.blog.utils.RxUtil;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by home on 2017/8/25.
 */

public class LoginPrenster extends LoginContract.Prenster {

    @Override
    void doLogin() {
        getModel().login(getView().getUsername(), getView().getPassword())
                .compose(this.<OAuth>bindLife())//绑定生命周期防止内存泄漏
                .compose(RxUtil.<OAuth>io_main())
                .singleOrError()
                .subscribeWith(new DisposableSingleObserver<OAuth>() {
                    @Override
                    public void onSuccess(@NonNull OAuth oAuth) {
                        getView().loginSuccess();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getView().loginFail(e.getMessage());
                    }
                });
    }

    @Override
    public void onAttach(LoginContract.View view) {

    }

    @Override
    public void onDetach() {
    }
}
