# butai

butai is Android library that adds functions return the application is in foreground, background or return from background.

butai is inspired by [@yshrsmz](https://github.com/yshrsmz)'s [blog entry](http://yslibrary.net/2015/07/30/android_how_to_detect_app_is_background_or_not/) (in Japanese).

The main logic of this library is that the library counts up the number of running Activities using `Application#ActivityLifecycleCallbacks`. Based on the number of running Activities, `Butai` provides the application is in foreground/background.

# How to install & setup?

butai has [Java](library-java) and [Kotlin](library) implementations. Each has different steps to install and setup.

Please read each README.

* [Java](library-java/README.md)
* [Kotlin](library/README.md)

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