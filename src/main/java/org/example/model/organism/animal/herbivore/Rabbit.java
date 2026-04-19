package org.example.model.organism.animal.herbivore;

public class Rabbit extends Herbivore {
    private static final double WEIGHT = 400;
    private static final int MAX_POPULATION = 50;
    private static final int SPEED = 2;
    private static final double FOOD_NEED = 50;

    public Rabbit() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
    }
}
