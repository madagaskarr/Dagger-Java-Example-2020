package com.example.dagger_java_example_2020.Components;

import com.example.dagger_java_example_2020.Car;
import com.example.dagger_java_example_2020.Engine;
import com.example.dagger_java_example_2020.MainActivity;

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

    // Using constructor injection we can get a Car object or
    // any other object creating an instance of the interface
    // implementation and use getter methods. But many times
    // we need to inject our dependencies as field variables.
    // For that reason we need to tell Dagger which classes
    // we will be injecting them into. For that we simply
    // create void method with argument of the class we want
    // to inject to. In this case it is MainActivity.
    void inject(MainActivity mainActivity);
}
