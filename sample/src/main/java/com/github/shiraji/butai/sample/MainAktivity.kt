package com.github.shiraji.butai.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainAktivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, MainAktivity::class.java).apply { }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_aktivity)
    }

    override fun onStart() {
        super.onStart()
        if ((application as MyApplication).isForeground()) Log.d("MainAktivity", "App is foreground")
        if ((application as MyApplication).isReturnedFromBackground()) Log.d("MainAktivity", "App returns from background")
    }

    override fun onStop() {
        super.onStop()
        if ((application as MyApplication).isForeground()) Log.d("MainAktivity", "App is still foreground")
        if ((application as MyApplication).isBackground()) Log.d("MainAktivity", "App goes to background")
    }

}
