package org.example.model.organism.animal.predator;

import org.example.config.EatMatrix;
import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.Organism;
import org.example.model.organism.animal.Animal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    @Override
    public void eat(GameField field) {

        Cell cell = field.getCells()[x][y];

        System.out.println("Predator: " + this.getClass().getSimpleName());

        for (Map.Entry<Class<? extends Organism>, Set<Organism>> entry : cell.getResidents().entrySet()) {
            Class<? extends Organism> preyClass = entry.getKey();
            int chance = EatMatrix.getChance(this.getClass(), preyClass);
            //System.out.println("Checking: " + preyClass.getSimpleName() + " chance=" + chance);
            if (chance <= 0) {
                continue;
            }
            for (Organism prey : new HashSet<>(entry.getValue())) {
                System.out.println("Trying to eat: " + prey.getClass().getSimpleName());
                if (tryEat(chance)) {
                    System.out.println("SUCCESS EAT");
                    cell.removeResident(prey);
                    return;
                } else {
                    System.out.println("FAILED");
                }
            }
        }

        for (Map.Entry<Class<? extends Organism>, Set<Organism>> entry : cell.getResidents().entrySet()) {

            Class<? extends Organism> preyClass = entry.getKey();
            int chance = EatMatrix.getChance(this.getClass(), preyClass);
            if (chance <= 0) {
                continue;
            }
            for (Organism prey : new HashSet<>(entry.getValue())) {
                if (tryEat(chance)) {
                    cell.removeResident(prey);
                    return;
                }
            }
        }
    }

    protected boolean tryEat(int chance) {
        return ThreadLocalRandom.current().nextInt(100) < chance;
    }
}
