package org.example.model.organism.animal;

import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.Movable;
import org.example.model.organism.Organism;
import org.example.model.organism.Reproducible;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Organism, Movable, Reproducible {
    protected int x;
    protected int y;
    protected int speed;

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void eat(GameField field) {

    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
}
