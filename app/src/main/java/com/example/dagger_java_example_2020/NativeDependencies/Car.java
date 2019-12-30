package com.example.dagger_java_example_2020.NativeDependencies;

import android.util.Log;

import com.example.dagger_java_example_2020.ExternalDependencies.CustomizedEdition;

import javax.inject.Inject;

// We created a Car class that needs an Engine and Wheels,
public class Car {

    private static final String TAG = "abrakadabra";

    private Engine engine;

    // This is the same field injection but in case of MainActivity
    // we had to add injector method into Component because we
    // didn't create a MainActivity (Android) and we can't annotate
    // it's constructor with @Inject. But Wheels class we created and
    // annotated. That is why when Dagger starts building this Car object
    // it first will call constructor, then fields and the methods. Even
    // thought we are not adding Wheels thought the constructor we are
    // doing it via fields. So remember we need let somehow know where
    // we will inject our dependencies if we are not the owner of the class.
    @Inject
    Wheels wheels;

    // This object is being injected through the module. This is external
    // dependency and that is why we can't annotate it's constructor but
    // instead we can create a provider odule and add that to the component.
    @Inject
    CustomizedEdition customizedEdition;

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
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        Log.d(TAG, "Driving...");
    }

    // In general we have three places where we can put @Inject
    // annotation: field, constructor and method. Method injection
    // is something weird. Not that many people use it. But the idea
    // is to use it when we need to call a method where we need a
    // dependency. This is already bad design but if you have a
    // situation where you need it don;t forget to annotate a method.
    // And Dagger will call this method automatically. If you don't
    // Dagger will not call this method. One fundamental difference
    // about method injection that differs from the way you seem to be
    // using it is that method injection is just another way for Dagger
    // to send in dependencies when constructing or injecting a DI-ready
    // object, which means that @Inject-annotated methods are meant to be
    // called by Dagger once on construction and not from within your own code.
    // This makes it very very unlikely that you would @Inject-annotate any other
    // method that has meaningful side effects or return values. Instead, treat
    // method injection as a post-facto opportunity for constructor-style injection.
    @Inject
    public void useRemote(Remote remote) {
        remote.setRemoteOwnerCar();
    }

    // Just for a demonstration purposes a method which checks
    // if the current Wheels is null or instantiated fully.
    public boolean isWheelsNullWithinCarClass() {
        if (wheels != null) {
            Log.d(TAG, "Within Car class wheels are instantiated!");
            return false;
        } else {
            Log.d(TAG, "NULL-NULL-NULL");
            return true;
        }
    }

}
