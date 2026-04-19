package org.example.model.organism.animal.herbivore;

public class Buffalo extends Herbivore {
    private static final double WEIGHT = 700;
    private static final int MAX_POPULATION = 10;
    private static final int SPEED = 3;
    private static final double FOOD_NEED = 100;

    public Buffalo() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
    }
}