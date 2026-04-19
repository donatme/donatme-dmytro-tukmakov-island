package org.example.model.organism.animal.herbivore;

public class Caterpillar extends Herbivore {
    private static final double WEIGHT = 0.01;
    private static final int MAX_POPULATION = 1000;
    private static final int SPEED = 0;
    private static final double FOOD_NEED = 0;

    public Caterpillar() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
    }
}