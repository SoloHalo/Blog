package com.cql.blog.data.helper;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by CQL on 2017/8/23.
 */

public class BaseHelper {
    HttpLoggingInterceptor mLog;


    public BaseHelper() {
        mLog = new HttpLoggingInterceptor();
    }
}
