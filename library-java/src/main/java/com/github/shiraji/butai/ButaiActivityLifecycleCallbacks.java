package com.github.shiraji.butai;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class ButaiActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks, Butai {

    private int runningActivities = 0;

    private AppStatus appStatus = AppStatus.JUST_APPEARED;

    @Override
    public void onActivityStarted(Activity activity) {
        if (runningActivities == 0) appStatus = AppStatus.JUST_APPEARED;
        else if (runningActivities > 0) appStatus = AppStatus.FOREGROUND;
        else appStatus = AppStatus.BACKGROUND;
        runningActivities++;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        runningActivities--;
        if (runningActivities <= 0) {
            appStatus = AppStatus.BACKGROUND;
            runningActivities = 0;
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public boolean isReturnedFromBackground() {
        return appStatus == AppStatus.JUST_APPEARED;
    }

    @Override
    public boolean isBackground() {
        return !isForeground();
    }

    @Override
    public boolean isForeground() {
        return appStatus.isForeground;
    }
}
