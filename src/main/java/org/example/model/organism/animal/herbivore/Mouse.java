package org.example.model.organism.animal.herbivore;

public class Mouse extends Herbivore {
    private static final double WEIGHT = 1;
    private static final int MAX_POPULATION = 200;
    private static final int SPEED = 4;
    private static final double FOOD_NEED = 0.15;

    public Mouse() {
        super(WEIGHT, MAX_POPULATION, SPEED, FOOD_NEED);
        eatingProbabilities.put(Caterpillar.class, 90);
    }
}
