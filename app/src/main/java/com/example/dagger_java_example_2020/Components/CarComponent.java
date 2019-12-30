package com.example.dagger_java_example_2020.Components;

import com.example.dagger_java_example_2020.ExternalDependencies.CustomizedEdition;
import com.example.dagger_java_example_2020.Modules.CustomizedEditionModule;
import com.example.dagger_java_example_2020.NativeDependencies.Car;
import com.example.dagger_java_example_2020.MainActivity;

import dagger.Component;

// Component is the entry point for getting dependencies. Again
// Dagger is only a code generator. Dagger will create an
// implementation for this interface methods because all the
// required classes we have annotated with @Inject annotation.

// Component can use internal and external dependencies. For
// external ones we use modules and provider methods. Here
// we need to add all the modules that we will be use in
// the component.
@Component(modules = {CustomizedEditionModule.class})
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
