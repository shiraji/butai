package com.github.shiraji.butai

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

@Suppress("IllegalIdentifier")
class ButaiActivityLifecycleCallbacksTest {
    private val butai = ButaiActivityLifecycleCallbacks()

    @Test fun `test when butai calls onActivityStarted, isReturnedFromBackground() is true`() {
        butai.onActivityStarted(null)
        assertTrue(butai.isReturnedFromBackground())
    }

    @Test fun `test when activity goes background, isBackground() is true`() {
        butai.onActivityStarted(null)
        butai.onActivityStopped(null)
        assertTrue(butai.isBackground())
    }

    @Test fun `test when 2 activities start, isReturnedFromBackground() is false`() {
        butai.onActivityStarted(null)
        butai.onActivityStarted(null)
        assertFalse(butai.isReturnedFromBackground())
        assertTrue(butai.isForeground())
    }

    @Test fun `test when 2 activities start and one end, isReturnedFromBackground() is false`() {
        butai.onActivityStarted(null)
        butai.onActivityStarted(null)
        butai.onActivityStopped(null)
        assertFalse(butai.isReturnedFromBackground())
        assertTrue(butai.isForeground())
    }

}