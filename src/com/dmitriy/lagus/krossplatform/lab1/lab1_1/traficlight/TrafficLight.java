package com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight;

/**
 * Created by lagus on 3/21/2017.
 */
public abstract class TrafficLight {

    private Color state;
    private Location location;
    private Long tact;

    public Long getTact() {
        return tact;
    }

    public void setTact(Long tact) {
        this.tact = tact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setState(Color color) {
        this.state = color;
    }

    public Color getState() {
        return this.state;
    }

    public abstract void next() throws TrafficLightUnexpectedStateException;
}
