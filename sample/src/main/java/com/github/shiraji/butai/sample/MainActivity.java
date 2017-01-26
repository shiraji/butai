package com.github.shiraji.butai.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.gotoNextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MainAktivity.Companion.createIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (((MyApplication) getApplication()).isReturnedFromBackground()) {
            Log.d("MainActivity", "Application entry");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (((MyApplication) getApplication()).isBackground()) {
            Log.d("MainActivity", "Go to background");
        }
    }
}
