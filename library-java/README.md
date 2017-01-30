# butai java

This is the module for butai Java implementation.

# How to install?

Use gradle where `LATEST_VERSION` is [ ![Download](https://api.bintray.com/packages/shiraji/maven/butai-java/images/download.svg) ](https://bintray.com/shiraji/maven/butai-java/_latestVersion)

```gradle
compile 'com.github.shiraji:butai-java:LATEST_VERSION'
```

# How to setup?

Create a custom Application in Java. Implement `Butai` interface. Then call `ButaiDelegate#init(Application)` to initialize the library.

```java
public class MyApp extends Application implements Butai {

    @Override
    public void onCreate() {
        super.onCreate();
        ButaiDelegate.init(this);
    }

    @Override
    public boolean isReturnedFromBackground() {
        return ButaiDelegate.isReturnedFromBackground();
    }

    @Override
    public boolean isBackground() {
        return ButaiDelegate.isBackground();
    }

    @Override
    public boolean isForeground() {
        return ButaiDelegate.isForeground();
    }
}

```

Now, you are ready.

# What the app status can get?

`Butai` interface has following method signatures in kotlin.

```java
public boolean isReturnedFromBackground()
public boolean isBackground()
public boolean isForeground()
```

* `isReturnedFromBackground()` true if the app shows up to foreground, false otherwise. This is true until other Activity launch or kill the Activity.
* `isBackground()` true if the app go to background, false otherwise.
* `isForeground()` true if the app is on foreground, false otherwise.

# How to get the app status?

`MyApplication` class above delegate these methods using Class Delegation.

```java
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

```
