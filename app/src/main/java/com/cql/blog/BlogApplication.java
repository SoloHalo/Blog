package com.cql.blog;

import android.app.Application;
import android.os.Handler;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by CQL on 2017/8/23.
 */

public class BlogApplication extends Application{
    private static BlogApplication application;

    private Handler mHandler;
    private RefWatcher mRefWatcher;

    public static BlogApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        mRefWatcher = LeakCanary.install(this);
        mHandler = new Handler();

    }

    public Handler getHandler() {
        return mHandler;
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }
}
