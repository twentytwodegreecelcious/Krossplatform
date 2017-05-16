package com.dmitriy.lagus.krossplatform.lab1.lab1_2;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by lagus on 3/21/2017.
 */
public class RangeOfFlightCalculation {

    private final double g = 9.80665;
    private final double RADIANTODEGREE = 57.2958;
    private double alpha;
    private double velocity;

    public RangeOfFlightCalculation(double alpha, double velocity) {
        this.alpha = alpha;
        this.velocity = velocity;
    }

    public double performCalculations() {
            return Math.pow(velocity, 2) * Math.sin(10*RADIANTODEGREE) / g;
    }
}
