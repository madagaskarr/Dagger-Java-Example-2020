package com.example.dagger_java_example_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dagger_java_example_2020.Components.CarComponent;
import com.example.dagger_java_example_2020.Components.DaggerCarComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To get all our dependencies we need to create and instance
        // of our component implementation class which will have all
        // getter methods.
        CarComponent carComponent = DaggerCarComponent.create();
        car = carComponent.getCar();
        car.drive();

    }
}
