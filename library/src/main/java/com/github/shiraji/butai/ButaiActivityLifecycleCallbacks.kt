package com.github.shiraji.butai

import android.app.Activity
import android.app.Application
import android.os.Bundle

internal class ButaiActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks, Butai {

    private val delegate = ButaiActivityLifecycleCallbacksDelegate()

    override fun onActivityStarted(p0: Activity?) = delegate.onActivityStarted()
    override fun onActivityStopped(p0: Activity?) = delegate.onActivityStopped()
    override fun onActivityPaused(p0: Activity?) = Unit
    override fun onActivityDestroyed(p0: Activity?) = Unit
    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) = Unit
    override fun onActivityCreated(p0: Activity?, p1: Bundle?) = Unit
    override fun onActivityResumed(p0: Activity?) = Unit
    override fun isReturnedFromBackground() = delegate.isReturnedFromBackground
    override fun isBackground() = delegate.isBackground
    override fun isForeground() = delegate.isForeground
}