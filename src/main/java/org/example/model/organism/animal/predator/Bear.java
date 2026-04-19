package org.example.model.organism.animal.predator;

import org.example.model.organism.animal.herbivore.*;

public class Bear extends Predator {
    private static final double WEIGHT = 500;
    private static final int MAX_POPULATION = 5;
    private static final int SPEED = 2;
    private static final double FOOD_NEED = 80;

    public Bear() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Boa.class, 80);
        eatingProbabilities.put(Horse.class, 40);
        eatingProbabilities.put(Deer.class, 80);
        eatingProbabilities.put(Rabbit.class, 80);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Sheep.class, 70);
        eatingProbabilities.put(Goat.class, 70);
        eatingProbabilities.put(Boar.class, 50);
        eatingProbabilities.put(Buffalo.class, 20);
        eatingProbabilities.put(Duck.class, 10);
    }
}

