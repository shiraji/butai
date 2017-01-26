package com.github.shiraji.butai.sample

import android.app.Application
import com.github.shiraji.butai.Butai
import com.github.shiraji.butai.ButaiDelegate

class MyApplication : Application(), Butai by ButaiDelegate {
    override fun onCreate() {
        super.onCreate()
        ButaiDelegate.init(this)
    }
}