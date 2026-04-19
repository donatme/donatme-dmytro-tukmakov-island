package org.example.model.organism.animal.predator;

import org.example.model.organism.animal.herbivore.*;

public class Fox extends Predator {

    private static final double WEIGHT = 8;
    private static final int MAX_POPULATION = 30;
    private static final int SPEED = 2;
    private static final double FOOD_NEED = 2;

    public Fox() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Rabbit.class, 70);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Duck.class, 60);
        eatingProbabilities.put(Caterpillar.class, 60);
    }
}