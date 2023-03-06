package com.mjc.stage2;

import java.util.Objects;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;


    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {

        if ( instance==null ) {
            synchronized ( ThreadSafeSingleton.class ) {
                if (instance==null ) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
