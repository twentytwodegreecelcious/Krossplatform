package com.dmitriy.lagus.krossplatform.lab1;

import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.TrafficLightUnexpectedStateException;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.Color;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.PedestrianTrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.RoadTrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.TrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_2.RangeOfFlightCalculation;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Scanner;

/**
 * Created by lagus on 3/21/2017.
 */
public class Application {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean status = true;
        try {
            switchTask();
        } catch (InvalidArgumentException exc) {
            status = false;
            System.err.println(exc);
        } finally {
            if (status) {
                System.out.println("Program has worked correctly");
            } else {
                System.out.println("Invalid arguments have been input");
            }

        }
    }

    public static void play() throws InterruptedException {
        TrafficLight pedestrianTrafficLight = new PedestrianTrafficLight(Color.RED);
        TrafficLight roadTrafficLight = new RoadTrafficLight(Color.GREEN);
        while (true) {
            Thread.sleep(5000);
            try {
                if (null != roadTrafficLight.getState()) {
                    if (roadTrafficLight.getState() != Color.YELLOW) {
                        System.out.println(roadTrafficLight);
                        System.out.println(pedestrianTrafficLight + "\n");
                        roadTrafficLight.next();
                        pedestrianTrafficLight.next();
                    } else {
                        Thread.sleep(1000);
                        System.out.println(roadTrafficLight + "\n");
                        roadTrafficLight.next();
                    }
                }
            } catch (TrafficLightUnexpectedStateException exc) {
                System.err.println(exc);
            }
        }
    }

    public static void calculate(double alpha, double velocity) throws InvalidArgumentException{
        RangeOfFlightCalculation rangeOfFlightCalculation = new RangeOfFlightCalculation(alpha, velocity);
        System.out.println("Answer is: " + rangeOfFlightCalculation.performCalculations());
    }

    public static void switchTask() throws InvalidArgumentException{
        System.out.println("Task 1 or 2? (1 - Traffic Light simulation, 2 - Calculation");
        String choice = scanner.nextLine();
        if (null != choice){
            if (choice.equals("1")) {
                try {
                    play();
                } catch (InterruptedException exc) {
                    System.err.println(exc);
                }
            } else if (choice.equals("2")){
                try {
                    System.out.println("Input alpha and velocity");
                    String alpha = scanner.nextLine();
                    String velocity = scanner.nextLine();
                    if (Double.parseDouble(alpha) == 0 || Double.parseDouble(velocity) == 0) {
                        System.out.println("Invalid Argument has been input");
                        throw new InvalidArgumentException(new String[]{});
                    }
                    calculate(Double.parseDouble(alpha), Double.parseDouble(velocity));
                } catch (InvalidArgumentException exc) {
                    System.err.println(exc);
                }
            }

        }
    }
}
