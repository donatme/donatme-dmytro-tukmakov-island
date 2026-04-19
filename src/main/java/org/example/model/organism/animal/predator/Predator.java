package org.example.model.organism.animal.predator;

import org.example.model.organism.animal.Animal;

public abstract class Predator extends Animal {

    protected Predator(double weight, int maxPopulation, int speed, double foodNeeded) {
        super(weight, maxPopulation, speed, foodNeeded);
    }
}
