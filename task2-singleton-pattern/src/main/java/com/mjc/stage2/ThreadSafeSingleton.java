package com.mjc.stage2;

import java.util.Objects;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    public static synchronized ThreadSafeSingleton getInstance() {

        if ( Objects.isNull(instance) ) {
            synchronized ( ThreadSafeSingleton.class ) {
                if ( Objects.isNull(instance) ) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
