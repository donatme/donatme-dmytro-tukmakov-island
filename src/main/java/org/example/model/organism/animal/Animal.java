package org.example.model.organism.animal;

import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.Eatable;
import org.example.model.organism.Movable;
import org.example.model.organism.Organism;
import org.example.model.organism.Reproducible;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Organism, Eatable, Movable, Reproducible {

    private static final double LOST_HEALTH_PER_MOVE = 0.15;
    private static final double LOST_HEALTH_PER_REPRODUCE = 0.2;

    protected int x;
    protected int y;
    private final UUID id = UUID.randomUUID();
    protected boolean isAlive = true;
    protected double health = 100.0;
    protected double weight;
    protected double foodNeeded;
    protected int speed;
    protected int maxPopulation;
    protected final Map<Class<? extends Organism>, Integer> eatingProbabilities = new HashMap<>();

    protected Animal(double weight, int maxPopulation, int speed, double foodNeeded) {
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void eat(GameField field) {
        Cell cell = field.getCells()[x][y];
        System.out.println(this.getClass().getSimpleName() + " tries to eat");
        for (Map.Entry<Class<? extends Organism>, Set<Organism>> entry : cell.getResidents().entrySet()) {
            Class<? extends Organism> preyClass = entry.getKey();
            int chance = eatingProbabilities.getOrDefault(preyClass, 0);
            if (chance <= 0) continue;
            for (Organism prey : new HashSet<>(entry.getValue())) {
                System.out.println("Trying: " + preyClass.getSimpleName());
                if (tryEat(chance)) {
                    System.out.println(this.getClass().getSimpleName() + " ate " + prey.getClass().getSimpleName());
                    cell.removeResident(prey);
                    return;
                } else {
                    System.out.println(this.getClass().getSimpleName() + " FAILED to eat " + prey.getClass().getSimpleName());
                }
            }
        }
    }

    protected boolean tryEat(int chance) {
        return ThreadLocalRandom.current().nextInt(100) < chance;
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void move(GameField field) {

        int dx = ThreadLocalRandom.current().nextInt(-speed, speed + 1);
        int dy = ThreadLocalRandom.current().nextInt(-speed, speed + 1);

        int newX = Math.max(0, Math.min(field.getWidth() - 1, x + dx));
        int newY = Math.max(0, Math.min(field.getHeight() - 1, y + dy));

        if (newX == x && newY == y) {
            return;
        }

        Cell[][] cells = field.getCells();
        cells[x][y].removeResident(this);
        cells[newX][newY].addResident(this);

        this.x = newX;
        this.y = newY;
    }

    @Override
    public boolean die() {
        return false;
    }

    private void decreaseHealthForMove() {
        health -= LOST_HEALTH_PER_MOVE * health;
        if (health <= 0) {
            die();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return isAlive == animal.isAlive && Double.compare(health, animal.health) == 0 && Double.compare(weight, animal.weight) == 0 && Double.compare(foodNeeded, animal.foodNeeded) == 0 && speed == animal.speed && maxPopulation == animal.maxPopulation && Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAlive, health, weight, foodNeeded, speed, maxPopulation);
    }
}
