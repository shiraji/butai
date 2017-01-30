package com.github.shiraji.butai;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ButaiActivityLifecycleCallbacksTest {
    private ButaiActivityLifecycleCallbacks butai = new ButaiActivityLifecycleCallbacks();

    @Test
    public void testOneActivity() {
        butai.onActivityStarted(null);
        assertTrue(butai.isReturnedFromBackground());
    }

    @Test
    public void testOneActivityStop() {
        butai.onActivityStarted(null);
        butai.onActivityStopped(null);
        assertTrue(butai.isBackground());
    }

    @Test
    public void testTwoActivity() {
        butai.onActivityStarted(null);
        butai.onActivityStarted(null);
        assertFalse(butai.isReturnedFromBackground());
        assertTrue(butai.isForeground());
    }

    @Test
    public void testTwoActivityOneEnd() {
        butai.onActivityStarted(null);
        butai.onActivityStarted(null);
        butai.onActivityStopped(null);
        assertFalse(butai.isReturnedFromBackground());
        assertTrue(butai.isForeground());
    }

}
