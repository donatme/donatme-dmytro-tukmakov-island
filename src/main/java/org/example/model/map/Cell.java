package org.example.model.map;

import org.example.model.organism.Organism;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cell {

    private final Map<Class<? extends Organism>, Set<Organism>> residents;

    public Cell(Map<Class<? extends Organism>, Set<Organism>> residents) {
        this.residents = residents;
    }

    public Map<Class<? extends Organism>, Set<Organism>> getResidents() {
        return residents;
    }

    public boolean addResident(Organism organism) {
        Class<? extends Organism> organismClass = organism.getClass();
        residents.putIfAbsent(organismClass, new HashSet<>());
        return residents.get(organismClass).add(organism);
    }

    public Collection<Organism> getAllOrganisms() {
        return residents.values()
                .stream()
                .flatMap(Set::stream)
                .toList();
    }

    public boolean removeResident(Organism organism) {
        Class<? extends Organism> organismClass = organism.getClass();
        Set<Organism> set = residents.get(organismClass);
        if (set == null) {
            return false;
        }
        boolean removed = set.remove(organism);
        if (set.isEmpty()) {
            residents.remove(organismClass);
        }
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (Map.Entry<Class<? extends Organism>, Set<Organism>> entry : residents.entrySet()) {
            for (Organism o : entry.getValue()) {
                sb.append(o.getClass().getSimpleName()).append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
