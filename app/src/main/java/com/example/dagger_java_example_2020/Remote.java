package com.example.dagger_java_example_2020;

import android.util.Log;

import javax.inject.Inject;

// This is our Remote object which is needed to call Car class's
// useRemote method.
public class Remote {

    private static final String TAG = "abrakadabra";

    // We need to annotate with @Inject annotation to let Dagger
    // know that this should be added to the Dependency Graph.
    // In other words whenever we need and Remote object Dagger
    // already know how to create it and provide.
    @Inject
    public Remote() {
    }

    // The method that is being called from Car class for demonstrating
    // methid injection with Dagger. Again bad idea!
    public void setRemoteOwnerCar() {
        Log.d(TAG, "Car has been assigned to this remote");
    }
}
