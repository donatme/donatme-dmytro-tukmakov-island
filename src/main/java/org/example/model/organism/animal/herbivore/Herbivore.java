package org.example.model.organism.animal.herbivore;

import org.example.model.organism.animal.Animal;
import org.example.model.organism.plant.Plant;

public abstract class Herbivore extends Animal {

    protected Herbivore(double weight, int maxPopulation, int speed, double foodNeeded) {
        super(weight, maxPopulation, speed, foodNeeded);
        eatingProbabilities.put(Plant.class, 100);
    }
}
