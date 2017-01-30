package com.github.shiraji.butai;

enum AppStatus {
    BACKGROUND(false),
    JUST_APPEARED(true),
    FOREGROUND(true);

    boolean isForeground;

    AppStatus(boolean isForeground) {
        this.isForeground = isForeground;
    }
}
