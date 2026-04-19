package org.example.model.map;

import org.example.model.organism.Organism;
import org.example.model.organism.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameField {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean addCell(Organism organism, int x, int y) {
        if (organism instanceof Animal animal) {
            animal.setPosition(x, y);
        }
        return cells[x][y].addResident(organism);
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell cell = cells[i][j];
                for (Set<Organism> set : cell.getResidents().values()) {
                    for (Organism organism : set) {
                        if (organism instanceof Animal animal) {
                            animals.add(animal);
                        }
                    }
                }
            }
        }
        return animals;
    }
}
