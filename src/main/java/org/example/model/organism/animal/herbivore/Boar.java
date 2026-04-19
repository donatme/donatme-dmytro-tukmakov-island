package org.example.model.organism.animal.herbivore;

public class Boar extends Herbivore {
    private static final double WEIGHT = 400;
    private static final int MAX_POPULATION = 50;
    private static final int SPEED = 2;
    private static final double FOOD_NEED = 50;

    public Boar() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Mouse.class, 50);
        eatingProbabilities.put(Caterpillar.class, 90);
    }
}