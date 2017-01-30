package com.github.shiraji.butai;

import android.app.Application;


public class ButaiDelegate {
    private static ButaiActivityLifecycleCallbacks callback = new ButaiActivityLifecycleCallbacks();

    public static void init(Application application) {
        application.registerActivityLifecycleCallbacks(callback);
    }

    public static boolean isReturnedFromBackground() {
        return callback.isReturnedFromBackground();
    }

    public static boolean isBackground() {
        return callback.isBackground();
    }

    public static boolean isForeground() {
        return callback.isForeground();
    }
}
