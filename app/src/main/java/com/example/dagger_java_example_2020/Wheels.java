package com.example.dagger_java_example_2020;

import javax.inject.Inject;

// This is our Wheels object which is needed to construct Car
public class Wheels {

    // We need to annotate with @Inject annotation to let Dagger
    // know that this should be added to the Dependency Graph.
    // In other words whenever we need and Wheels object Dagger
    // already know how to create it and provide.
    @Inject
    public Wheels() {
    }
}
