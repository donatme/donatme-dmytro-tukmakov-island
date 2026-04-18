package org.example.config;

import org.example.model.organism.Organism;
import org.example.model.organism.animal.Animal;
import org.example.model.organism.animal.herbivore.Horse;
import org.example.model.organism.animal.herbivore.Rabbit;
import org.example.model.organism.animal.predator.Wolf;
import org.example.model.organism.plant.Plant;

import java.util.HashMap;
import java.util.Map;

public class EatMatrix {
    private static final Map<Class<? extends Animal>, Map<Class<? extends Organism>, Integer>> matrix = new HashMap<>();

    static {
        Map<Class<? extends Organism>, Integer> wolfMap = new HashMap<>();
        wolfMap.put(Rabbit.class, 60);
        wolfMap.put(Horse.class, 10);
        matrix.put(Wolf.class, wolfMap);

        Map<Class<? extends Organism>, Integer> rabbitMap = new HashMap<>();
        rabbitMap.put(Plant.class, 100);
        matrix.put(Rabbit.class, rabbitMap);
    }

    public static int getChance(Class<? extends Animal> predator, Class<? extends Organism> prey) {
        return matrix.getOrDefault(predator, Map.of()).getOrDefault(prey, 0);
    }

    private EatMatrix() {
    }
}
