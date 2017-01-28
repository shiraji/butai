package com.github.shiraji.butai

import android.app.Activity
import android.app.Application
import android.os.Bundle

internal class ButaiActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks, Butai {
    enum class AppStatus(val isForeground: Boolean) {
        BACKGROUND(false),
        JUST_APPEARED(true),
        FOREGROUND(true);
    }

    private var runningActivities = 0

    private var appStatus = AppStatus.FOREGROUND

    override fun onActivityStarted(p0: Activity?) {
        appStatus = when {
            runningActivities == 0 -> AppStatus.JUST_APPEARED
            runningActivities > 0 -> AppStatus.FOREGROUND
            else -> AppStatus.BACKGROUND
        }
        runningActivities++
    }

    override fun onActivityStopped(p0: Activity?) {
        runningActivities--
        if (runningActivities == 0) appStatus = AppStatus.BACKGROUND
    }

    override fun onActivityPaused(p0: Activity?) = Unit
    override fun onActivityDestroyed(p0: Activity?) = Unit
    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) = Unit
    override fun onActivityCreated(p0: Activity?, p1: Bundle?) = Unit
    override fun onActivityResumed(p0: Activity?) = Unit

    override fun isReturnedFromBackground() = appStatus == AppStatus.JUST_APPEARED
    override fun isBackground() = !isForeground()
    override fun isForeground() = appStatus.isForeground
}