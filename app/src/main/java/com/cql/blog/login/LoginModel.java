package com.cql.blog.login;

import com.cql.blog.model.OAuth;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by home on 2017/8/25.
 */

public class LoginModel implements LoginContract.Model {


    @Override
    public Observable<OAuth> login(String username, String password) {
        return Observable.just(0).delay(10, TimeUnit.SECONDS)
                .map(new Function<Integer, OAuth>() {
                    @Override
                    public OAuth apply(@NonNull Integer integer) throws Exception {
                        return new OAuth();
                    }
                });
    }
}
