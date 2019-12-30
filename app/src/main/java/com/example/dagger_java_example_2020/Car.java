package com.example.dagger_java_example_2020;

import android.util.Log;

import javax.inject.Inject;

// We created a Car class that needs an Engine and Wheels,
public class Car {

    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;

    // We passed Engine and Wheels as an constructor arguments.
    // This process is called Constructor Injection, where
    // @Inject annotation means we ask Dagger to create these
    // dependencies. And for that all the constructor objects
    // Should be annotated with the same @Inject annotation.
    // If no otherwise we will have compile time error.
    // So we need to annotate argument classes with the same way.
    // Because Dagger will start building Car object but will not
    // find Engine and Wheels in Dependency graph.
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "Driving...");
    }
}
