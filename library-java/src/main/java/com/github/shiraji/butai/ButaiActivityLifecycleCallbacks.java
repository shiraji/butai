package com.github.shiraji.butai;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class ButaiActivityLifecycleCallbacks implements
        Application.ActivityLifecycleCallbacks, Butai {

    private ButaiActivityLifecycleCallbacksDelegate delegate = new ButaiActivityLifecycleCallbacksDelegate();

    @Override
    public void onActivityStarted(Activity activity) {
        delegate.onActivityStarted();
    }

    @Override
    public void onActivityStopped(Activity activity) {
        delegate.onActivityStopped();
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
        return delegate.isReturnedFromBackground();
    }

    @Override
    public boolean isBackground() {
        return delegate.isBackground();
    }

    @Override
    public boolean isForeground() {
        return delegate.isForeground();
    }
}
