package com.cql.blog.data.helper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by CQL on 2017/8/23.
 */

public class LoginHelper extends BaseHelper {
    private static final String BASE_BLOG_URL = "http://lh-blog.azurewebsites.net";

    private static LoginHelper mLoginHelper;

    public static LoginHelper getInstance(){
        if (mLoginHelper == null){
            mLoginHelper = new LoginHelper();
        }
        return mLoginHelper;
    }

    private LoginHelper(){
        OkHttpClient client = new OkHttpClient.Builder().writeTimeout(3000, TimeUnit.MILLISECONDS)
                .readTimeout(3000,TimeUnit.MILLISECONDS)
                .connectTimeout(3000,TimeUnit.MILLISECONDS)
                .addInterceptor(mLog)
                .build();

    }

}
