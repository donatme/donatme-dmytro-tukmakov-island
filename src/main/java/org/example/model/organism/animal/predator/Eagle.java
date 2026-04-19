package org.example.model.organism.animal.predator;

import org.example.model.organism.animal.herbivore.Duck;
import org.example.model.organism.animal.herbivore.Mouse;
import org.example.model.organism.animal.herbivore.Rabbit;

public class Eagle extends Predator {
    private static final double WEIGHT = 6;
    private static final int MAX_POPULATION = 20;
    private static final int SPEED = 3;
    private static final double FOOD_NEED = 1;

    public Eagle() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Fox.class, 70);
        eatingProbabilities.put(Rabbit.class, 90);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Duck.class, 80);
    }
}