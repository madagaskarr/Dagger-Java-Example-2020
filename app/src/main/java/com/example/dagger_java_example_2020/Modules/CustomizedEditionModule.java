package com.example.dagger_java_example_2020.Modules;

import com.example.dagger_java_example_2020.ExternalDependencies.CustomSeatFinish;
import com.example.dagger_java_example_2020.ExternalDependencies.CustomSportEditionEngine;
import com.example.dagger_java_example_2020.ExternalDependencies.CustomizedEdition;

import dagger.Module;
import dagger.Provides;

// Module is a class that contributes to the object graph. Here we can
// show Dagger how to create external dependencies. Usualy here you put
// Glade, Retrofit and other libraries.
@Module
public class CustomizedEditionModule {

    // Provides method are being used when we want add an object
    // to our object graph. Documentation says to use static methods.
    @Provides
    static CustomSeatFinish provideCustomSeatFinish() {
        return new CustomSeatFinish();
    }

    // Provides method are being used when we want add an object
    // to our object graph. Documentation says to use static methods.
    @Provides
    static CustomSportEditionEngine provideCustomSportEditionEngine() {
        return new CustomSportEditionEngine();
    }

    // Provides method are being used when we want add an object
    // to our object graph. Documentation says to use static methods.
    @Provides
    static CustomizedEdition provideCustomizedEdition(CustomSeatFinish customSeatFinish, CustomSportEditionEngine customSportEditionEngine) {
        return new CustomizedEdition(customSeatFinish, customSportEditionEngine);
    }
}
