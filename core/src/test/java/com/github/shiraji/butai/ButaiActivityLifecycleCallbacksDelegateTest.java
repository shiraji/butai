package com.github.shiraji.butai;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ButaiActivityLifecycleCallbacksDelegateTest {
    private ButaiActivityLifecycleCallbacksDelegate butai = new ButaiActivityLifecycleCallbacksDelegate();

    @Test
    public void testOneActivity() {
        butai.onActivityStarted();
        assertTrue(butai.isReturnedFromBackground());
    }

    @Test
    public void testOneActivityStop() {
        butai.onActivityStarted();
        butai.onActivityStopped();
        assertTrue(butai.isBackground());
    }

    @Test
    public void testTwoActivity() {
        butai.onActivityStarted();
        butai.onActivityStarted();
        assertFalse(butai.isReturnedFromBackground());
        assertTrue(butai.isForeground());
    }

    @Test
    public void testTwoActivityOneEnd() {
        butai.onActivityStarted();
        butai.onActivityStarted();
        butai.onActivityStopped();
        assertFalse(butai.isReturnedFromBackground());
        assertTrue(butai.isForeground());
    }

}
