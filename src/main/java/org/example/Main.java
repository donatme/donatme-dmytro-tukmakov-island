package org.example;

import org.example.config.ApplicationContext;
import org.example.config.ApplicationLoader;
import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.Organism;
import org.example.model.organism.animal.Animal;
import org.example.model.organism.animal.herbivore.Rabbit;
import org.example.model.organism.animal.predator.Wolf;
import org.example.model.organism.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ApplicationLoader loader = ApplicationLoader.getInstance();
        ApplicationContext context = loader.init(2, 2);
        GameField gameField = context.getGameField();

        Wolf wolf1 = new Wolf();
        Wolf wolf2 = new Wolf();
        Rabbit rabbit1 = new Rabbit();
        Rabbit rabbit2 = new Rabbit();
        Plant plant = new Plant();

        int x = 0;
        int y = 0;

        gameField.addCell(wolf1, x, y);
        gameField.addCell(wolf2, x, y);
        gameField.addCell(rabbit1, x, y);
        gameField.addCell(rabbit2, x, y);
        gameField.addCell(plant, x, y);

        System.out.println("=== BEFORE ===");
        printField(gameField.getCells());
        printStats(gameField);

        List<Animal> animals = new ArrayList<>(gameField.getAllAnimals());

        for (Animal animal : animals) {
            animal.eat(gameField);
        }

        animals = new ArrayList<>(gameField.getAllAnimals());

        for (Animal animal : animals) {
            animal.move(gameField);
        }

        System.out.println("=== AFTER 1 TICK ===");
        printField(gameField.getCells());
        printStats(gameField);
    }

    private static void printField(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.println("cell[" + i + "," + j + "] " + cells[i][j]);
            }
        }
    }

    private static void printStats(GameField field) {
        System.out.println("--- STATS ---");
        Cell[][] cells = field.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                for (Map.Entry<Class<? extends Organism>, Set<Organism>> entry
                        : cell.getResidents().entrySet()) {
                    System.out.println(
                            "cell[" + i + "," + j + "] "
                                    + entry.getKey().getSimpleName()
                                    + " = " + entry.getValue().size()
                    );
                }
            }
        }
        System.out.println("--------------");
    }
}
