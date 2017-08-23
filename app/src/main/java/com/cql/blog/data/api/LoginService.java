package com.cql.blog.data.api;

import com.cql.blog.data.Constant;
import com.cql.blog.model.BlogResponse;
import com.cql.blog.model.User;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by CQL on 2017/8/23.
 */

public interface LoginService {

    @POST(Constant.LOGIN)
    Observable<BlogResponse<User>> Login(@Query("username") String username,
                                         @Query("password") String password);
}
