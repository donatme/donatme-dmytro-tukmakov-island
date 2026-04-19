package org.example.model.organism.animal.predator;

import org.example.model.organism.animal.herbivore.*;

public class Wolf extends Predator {
    private static final double WEIGHT = 50;
    private static final double FOOD_NEED = 8;
    private static final int SPEED = 3;
    private static final int MAX_POPULATION = 30;

    public Wolf() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Horse.class, 10);
        eatingProbabilities.put(Deer.class, 15);
        eatingProbabilities.put(Rabbit.class, 60);
        eatingProbabilities.put(Mouse.class, 80);
        eatingProbabilities.put(Goat.class, 60);
        eatingProbabilities.put(Sheep.class, 70);
        eatingProbabilities.put(Boar.class, 15);
        eatingProbabilities.put(Buffalo.class, 10);
        eatingProbabilities.put(Duck.class, 40);
    }
}
