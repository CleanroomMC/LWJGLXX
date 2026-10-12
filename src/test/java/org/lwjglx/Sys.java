package org.lwjglx;

// Keep input queue tests headless by replacing only the native timestamp provider.
public class Sys {

    public static long getNanoTime() {
        return System.nanoTime();
    }
}
