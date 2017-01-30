package com.github.shiraji.butai

import android.app.Application

object ButaiDelegate : Butai {

    private val callback = ButaiActivityLifecycleCallbacks()

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(callback)
    }

    override fun isReturnedFromBackground() = callback.isReturnedFromBackground
    override fun isBackground() = callback.isBackground
    override fun isForeground() = callback.isForeground
}