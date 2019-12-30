package com.example.dagger_java_example_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dagger_java_example_2020.Components.CarComponent;
import com.example.dagger_java_example_2020.Components.DaggerCarComponent;
import com.example.dagger_java_example_2020.NativeDependencies.Car;
import com.example.dagger_java_example_2020.NativeDependencies.Wheels;
import com.example.dagger_java_example_2020.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private Car car;

    // For injecting into class we need to use the same
    // @Inject annotation. This called field injection.
    @Inject
    Wheels wheels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To get all our dependencies we need to create and instance
        // of our component implementation class which will have all
        // getter methods.
        CarComponent carComponent = DaggerCarComponent.create();

        // Calling this method we are telling Dagger that this is the class
        // where we want inject all the dependencies in the component.
        carComponent.inject(this);

        car = carComponent.getCar();
        car.drive();
        car.isWheelsNullWithinCarClass();
        wheels.isWheelsNull();


    }
}
