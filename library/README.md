# butai kotlin

This is the module for butai Kotlin implementation.

# How to install?

Use gradle where `LATEST_VERSION` is [![Download](https://api.bintray.com/packages/shiraji/maven/butai/images/download.svg)](https://bintray.com/shiraji/maven/butai/_latestVersion)

```gradle
compile 'com.github.shiraji:butai:LATEST_VERSION'
```

# How to setup?

butai setups is quite simple. Create a custom Application in kotlin. Implement `Butai` interface using Class Delegation. Then call `ButaiDelegate#init(Application)` to initialize the library.

```kotlin
class MyApplication : Application(), Butai by ButaiDelegate {
    override fun onCreate() {
        super.onCreate()
        ButaiDelegate.init(this)
    }
}
```

That's it. Now, you are ready.

# What the app status can get?

`Butai` interface has following method signatures in kotlin.

```kotlin
fun isReturnedFromBackground(): Boolean
fun isBackground(): Boolean
fun isForeground(): Boolean
```

* `isReturnedFromBackground()` true if the app shows up to foreground, false otherwise. This is true until other Activity launch or kill the Activity.
* `isBackground()` true if the app go to background, false otherwise.
* `isForeground()` true if the app is on foreground, false otherwise.

# How to get the app status?

`MyApplication` class above delegate these methods using Class Delegation.

```kotlin
class MainAktivity : AppCompatActivity() {

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
```
