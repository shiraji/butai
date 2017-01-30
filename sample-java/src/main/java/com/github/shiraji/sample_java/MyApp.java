package com.github.shiraji.sample_java;

import android.app.Application;

import com.github.shiraji.butai.Butai;
import com.github.shiraji.butai.ButaiDelegate;


public class MyApp extends Application implements Butai {

    @Override
    public void onCreate() {
        super.onCreate();
        ButaiDelegate.init(this);
    }

    @Override
    public boolean isReturnedFromBackground() {
        return ButaiDelegate.isReturnedFromBackground();
    }

    @Override
    public boolean isBackground() {
        return ButaiDelegate.isBackground();
    }

    @Override
    public boolean isForeground() {
        return ButaiDelegate.isForeground();
    }
}
