package org.example.model.organism.animal.herbivore;

import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.Organism;
import org.example.model.organism.animal.Animal;
import org.example.model.organism.plant.Plant;

import java.util.Set;

public abstract class Herbivore extends Animal {

    @Override
    public void eat(GameField field) {
        Cell cell = field.getCells()[x][y];
        Set<Organism> plants = cell.getResidents().get(Plant.class);
        if (plants == null || plants.isEmpty()) {
            return;
        }
        Organism plant = plants.iterator().next();
        cell.removeResident(plant);
    }
}
