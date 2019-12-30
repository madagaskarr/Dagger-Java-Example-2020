package com.example.dagger_java_example_2020.Components;

import com.example.dagger_java_example_2020.Car;
import com.example.dagger_java_example_2020.Engine;

import dagger.Component;

// Component is the entry point for getting dependencies. Again
// Dagger is only a code generator. Dagger will create an
// implementation for this interface methods because all the
// required classes we have annotated with @Inject annotation.
@Component
public interface CarComponent {

    // This interface method is telling Dagger to create a Car
    // object which means to look through the Dependency Graph
    // find all required dependencies and build a Car object.
    Car getCar();
}
