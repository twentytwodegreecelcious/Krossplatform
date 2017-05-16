package com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight;

/**
 * Created by lagus on 3/21/2017.
 */
public class PedestrianTrafficLight extends TrafficLight {

    public PedestrianTrafficLight(Color color) {
        this.setState(color);
    }

    @Override
    public void next() throws TrafficLightUnexpectedStateException {
        if (null != this.getState() && this.getState().equals(Color.GREEN)) {
            this.setState(Color.RED);
        } else if (null != this.getState() && this.getState().equals(Color.RED)) {
            this.setState(Color.GREEN);
        } else {
            throw new TrafficLightUnexpectedStateException();
        }
    }

    @Override
    public String toString() {
        return "Pedestrian traffic light's state is:" + this.getState().toString();
    }
}
