# butai

This library is still alpha version. I don't recommend to use it at this moment.

butai is the kotlin Android library that extends classes (e.g. custom Application) have the state that the application is in foreground, background or return from background.

butai is inspaired by [@yshrsmz](https://github.com/yshrsmz)'s [blog entry](http://yslibrary.net/2015/07/30/android_how_to_detect_app_is_background_or_not/) (in Japanese).

The main concept of this library is counting up the number of running Activities using `Application.ActivityLifecycleCallbacks`. Based on the number of running Activities, `Butai` class provide the status of the app.

# How to install?

Use gradle where `LATEST_VERSION` is [![Download](https://api.bintray.com/packages/shiraji/maven/butai/images/download.svg)](https://bintray.com/shiraji/maven/butai/_latestVersion)

```gradle
compile 'com.github.shiraji:butai:LATEST_VERSION'
```

# How to setup?

butai setups is quite simple. Create a custom Application in kotlin. Implement Butai interface using Class Delegation. Then call `ButaiDelegate#init(Application)` to initialize.

```kotlin
class MyApplication : Application(), Butai by ButaiDelegate {
    override fun onCreate() {
        super.onCreate()
        ButaiDelegate.init(this)
    }
}
```

That's it. Now, you are ready.

# What is the status?

`Butai` interface has following method signitures.

```kotlin
    fun isReturnedFromBackground(): Boolean
    fun isBackground(): Boolean
    fun isForeground(): Boolean
```

* `isReturnedFromBackground()` true if the app shows up to foreground, false otherwise. This is true until other Activity launch or kill the Activity.
* `isBackground()` true if the app go to background, false otherwise.
* `isForeground()` true if the app is on foreground, false otherwise.

# How to get status

`MyApplication` class above delegate these methods using Class Delegation.

butai has a limitation that the status butai has is valid while the Activity lifecycle is from `onStart()` to `onStop()`.

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

So, DO NOT CALL `Butai`'s methods at `onCreate` or `onDestroy`.

# License

```
Copyright 2017 Yoshinori Isogai

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```