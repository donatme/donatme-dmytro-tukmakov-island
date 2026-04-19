package org.example.model.organism.animal.herbivore;

public class Goat extends Herbivore {
    private static final double WEIGHT = 60;
    private static final int MAX_POPULATION = 140;
    private static final int SPEED = 3;
    private static final double FOOD_NEED = 10;

    public Goat() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
    }
}
