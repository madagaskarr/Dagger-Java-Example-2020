package com.example.dagger_java_example_2020.ExternalDependencies;

public class CustomizedEdition {

    private CustomSeatFinish customSeatFinish;
    private CustomSportEditionEngine customSportEditionEngine;

    public CustomizedEdition(CustomSeatFinish customSeatFinish, CustomSportEditionEngine customSportEditionEngine) {
        this.customSeatFinish = customSeatFinish;
        this.customSportEditionEngine = customSportEditionEngine;
    }
}
