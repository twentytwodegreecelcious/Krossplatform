package com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight;

/**
 * Created by lagus on 3/21/2017.
 */
public class RoadTrafficLight extends TrafficLight {

    private Color previous;

    public RoadTrafficLight(Color color) {
        this.setState(color);
    }

    public Color getPrevious() {
        return previous;
    }

    public void next() throws TrafficLightUnexpectedStateException {
        if (null != this.getState() && this.getState().equals(Color.GREEN)) {
            previous = Color.GREEN;
            this.setState(Color.YELLOW);
        } else if (null != this.getState() && this.getState().equals(Color.RED)) {
            previous = Color.RED;
            this.setState(Color.YELLOW);
        } else if (null !=this.getState() && this.getState().equals(Color.YELLOW)){
            if (this.getPrevious().equals(Color.GREEN)) {
                this.setState(Color.RED);
            } else if (this.getPrevious().equals(Color.RED)) {
                this.setState(Color.GREEN);
            }
        } else {
            throw new TrafficLightUnexpectedStateException();
        }
    }

    @Override
    public String toString() {
        return "Road traffic light's state is:" + this.getState().toString();
    }
}
