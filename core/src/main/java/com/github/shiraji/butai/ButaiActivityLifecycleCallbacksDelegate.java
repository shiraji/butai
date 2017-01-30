package com.github.shiraji.butai;

final class ButaiActivityLifecycleCallbacksDelegate {
    private int runningActivities = 0;

    private AppStatus appStatus = AppStatus.JUST_APPEARED;

    public void onActivityStarted() {
        if (runningActivities == 0)
            appStatus = AppStatus.JUST_APPEARED;
        else if (runningActivities > 0)
            appStatus = AppStatus.FOREGROUND;
        else
            appStatus = AppStatus.BACKGROUND;
        runningActivities++;
    }

    public void onActivityStopped() {
        runningActivities--;
        if (runningActivities <= 0) {
            appStatus = AppStatus.BACKGROUND;
            runningActivities = 0;
        }
    }

    public boolean isReturnedFromBackground() {
        return appStatus == AppStatus.JUST_APPEARED;
    }

    public boolean isBackground() {
        return !isForeground();
    }

    public boolean isForeground() {
        return appStatus.isForeground;
    }
}
