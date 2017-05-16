package com.dmitriy.lagus.krossplatform.lab1.lab1_1.crossroad;

/**
 * Created by lagus on 3/22/2017.
 */
public class AmountOfTrafficLightsOverflowException extends Throwable {
    public String message;

    public AmountOfTrafficLightsOverflowException(String message) {
        this.message = message;
    }
}
