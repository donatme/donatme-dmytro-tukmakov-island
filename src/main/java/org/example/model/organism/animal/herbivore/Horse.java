package org.example.model.organism.animal.herbivore;

public class Horse extends Herbivore {
    private static final double WEIGHT = 400;
    private static final int MAX_POPULATION = 20;
    private static final int SPEED = 4;
    private static final double FOOD_NEED = 60;

    public Horse() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
    }
}
