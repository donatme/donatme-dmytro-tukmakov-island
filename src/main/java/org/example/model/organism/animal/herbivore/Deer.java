package org.example.model.organism.animal.herbivore;

import org.example.model.organism.plant.Plant;

public class Deer extends Herbivore {
    private static final double WEIGHT = 300;
    private static final int MAX_POPULATION = 20;
    private static final int SPEED = 4;
    private static final double FOOD_NEED = 50;

    public Deer() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Plant.class, 100);
    }
}
