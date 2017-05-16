package com.dmitriy.lagus.krossplatform.lab1.lab1_1.crossroad;

import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.Location;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.PedestrianTrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.RoadTrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.TrafficLight;

import java.util.*;

/**
 * Created by lagus on 3/22/2017.
 */
public abstract class CrossRoad implements Functioning {
    private List<TrafficLight> trafficLightList = new ArrayList<>();
    private int amountOfAdjoiningRoads;

    public int getAmountOfAdjoiningRoads() {
        return amountOfAdjoiningRoads;
    }

    public void setAmountOfAdjoiningRoads(int amountOfAdjoiningRoads) {
        this.amountOfAdjoiningRoads = amountOfAdjoiningRoads;
    }

    public List<TrafficLight> getTrafficLightList() {
        return trafficLightList;
    }

    public void setTrafficLightList(List<TrafficLight> trafficLightList) {
        this.trafficLightList = trafficLightList;
    }

    public void addTrafficLight(TrafficLight trafficLight) throws AmountOfTrafficLightsOverflowException {
        if (this.trafficLightList.size() == amountOfAdjoiningRoads) {
            throw new AmountOfTrafficLightsOverflowException("Traffic light hasn't been added");
        } else {
            this.trafficLightList.add(trafficLight);
        }
    }

    private void initializeLocationQueue(Queue<Location> locationQueue) {
        locationQueue.add(Location.NORTH);
        locationQueue.add(Location.SOUTH);
        locationQueue.add(Location.EAST);
        locationQueue.add(Location.WEST);
        locationQueue.add(Location.NORTHEAST);
        locationQueue.add(Location.NORTHWEST);
        locationQueue.add(Location.SOUTHEAST);
        locationQueue.add(Location.SOUTHWEST);
    }

    private void uninitializeLocationQueue(Queue<Location> locationQueue) {
        while (locationQueue.isEmpty())
            locationQueue.remove();
    }

    public List<TrafficLight> generate(int amountOfAdjoiningRoads) {
        Queue<Location> locationQueue = new Queue<Location>() {
            @Override
            public boolean add(Location location) {
                return false;
            }

            @Override
            public boolean offer(Location location) {
                return false;
            }

            @Override
            public Location remove() {
                return null;
            }

            @Override
            public Location poll() {
                return null;
            }

            @Override
            public Location element() {
                return null;
            }

            @Override
            public Location peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Location> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Location> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        initializeLocationQueue(locationQueue);
        for (TrafficLight trafficLight : this.getTrafficLightList()) {
            if (trafficLight instanceof RoadTrafficLight) {
                trafficLight.setLocation(locationQueue.peek());
            } else continue;
        }
        uninitializeLocationQueue(locationQueue);
        initializeLocationQueue(locationQueue);
        for (TrafficLight trafficLight : this.getTrafficLightList()) {
            if (trafficLight instanceof PedestrianTrafficLight) {
                trafficLight.setLocation(locationQueue.peek());
                locationQueue.remove();
            } else continue;
        }
        return this.trafficLightList;
    }

}

