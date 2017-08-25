package com.cql.blog.data.api;

import com.cql.blog.data.BlogResponse;
import com.cql.blog.model.LoginBody;
import com.cql.blog.model.OAuth;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by CQL on 2017/8/23.
 */

public interface LoginService {

    String LOGIN = "api/login";
    String REGISTER = "api/register";
    String REFRESH_LOGIN = "api/refresh_token";

    @POST(LOGIN)
    Observable<BlogResponse<OAuth>> Login(@Body LoginBody body);
}
