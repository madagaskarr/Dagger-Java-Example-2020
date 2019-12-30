package com.example.dagger_java_example_2020.NativeDependencies;

import android.util.Log;

import javax.inject.Inject;

// This is our Wheels object which is needed to construct Car
public class Wheels {
    private static final String TAG = "abrakadabra";

    // We need to annotate with @Inject annotation to let Dagger
    // know that this should be added to the Dependency Graph.
    // In other words whenever we need and Wheels object Dagger
    // already know how to create it and provide.
    @Inject
    public Wheels() {
    }

    // Just for a demonstration purposes a method which checks
    // if the current class is null or instantiated fully.
    public boolean isWheelsNull() {
        if (this != null) {
            Log.d(TAG, "Wheels are instantiated!");
            return false;
        } else {
            Log.d(TAG, "NULL");
            return true;
        }
    }


}
