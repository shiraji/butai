package com.github.shiraji.butai

interface Butai {
    fun isReturnedFromBackground(): Boolean
    fun isBackground(): Boolean
    fun isForeground(): Boolean
}
