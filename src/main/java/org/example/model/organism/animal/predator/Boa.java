package org.example.model.organism.animal.predator;

import org.example.model.organism.animal.herbivore.Caterpillar;
import org.example.model.organism.animal.herbivore.Duck;
import org.example.model.organism.animal.herbivore.Mouse;
import org.example.model.organism.animal.herbivore.Rabbit;

public class Boa extends Predator {
    private static final double WEIGHT = 15;
    private static final int MAX_POPULATION = 30;
    private static final int SPEED = 1;
    private static final double FOOD_NEED = 3;

    public Boa() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Rabbit.class, 70);
        eatingProbabilities.put(Mouse.class, 90);
        eatingProbabilities.put(Duck.class, 60);
        eatingProbabilities.put(Caterpillar.class, 60);
    }
}
