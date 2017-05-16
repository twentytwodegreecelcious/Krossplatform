package com.dmitriy.lagus.krossplatform.lab1.lab1_1.crossroad;

import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.Color;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.PedestrianTrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.RoadTrafficLight;
import com.dmitriy.lagus.krossplatform.lab1.lab1_1.traficlight.TrafficLight;

import java.util.*;

/**
 * Created by lagus on 3/29/2017.
 */
public class CrusiformCrossRoad extends CrossRoad {

    public CrusiformCrossRoad(Integer amountOfAdjoiningRoads) throws AmountOfTrafficLightsOverflowException{
        this.setAmountOfAdjoiningRoads(amountOfAdjoiningRoads);
        for (int i=0; i<amountOfAdjoiningRoads; i++) {
            this.addTrafficLight(new PedestrianTrafficLight(Color.GREEN));
            this.addTrafficLight(new RoadTrafficLight(Color.RED));
        }
    }

    public CrusiformCrossRoad(List<TrafficLight> trafficLightList) {
        if (trafficLightList.isEmpty()) return;
        this.setAmountOfAdjoiningRoads(new Integer(trafficLightList.size()/2));
        this.setTrafficLightList(trafficLightList);
    }

//    public void initializePairsList(List<Location.Pair> pairList) {
//        pairList.add(new Location.Pair(Location.NORTH, Location.SOUTH));
//        pairList.add(new Location.Pair(Location.EAST, Location.WEST));
//        pairList.add(new Location.Pair(Location.NORTHEAST, Location.SOUTHWEST));
//        pairList.add(new Location.Pair(Location.NORTHWEST, Location.SOUTHEAST));
//    }

    @Override
    public void function() {
        
    }
    @Override
    public boolean hasCollisions() {
        return false; //fixme
    }
}


