package com.github.shiraji.sample_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (((MyApp) getApplication()).isForeground()) Log.d("MainAktivity", "App is foreground");
        if (((MyApp) getApplication()).isReturnedFromBackground()) Log.d("MainAktivity", "App returns from background");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (((MyApp) getApplication()).isForeground()) Log.d("MainAktivity", "App is still foreground");
        if (((MyApp) getApplication()).isBackground()) Log.d("MainAktivity", "App goes to background");
    }
}
