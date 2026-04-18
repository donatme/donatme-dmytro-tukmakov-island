package org.example;

import org.example.config.ApplicationContext;
import org.example.config.ApplicationLoader;
import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.animal.Animal;
import org.example.model.organism.animal.herbivore.Horse;
import org.example.model.organism.animal.herbivore.Rabbit;
import org.example.model.organism.animal.predator.Wolf;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationLoader loader = ApplicationLoader.getInstance();
        ApplicationContext context = loader.init(3, 4);
        GameField gameField = context.getGameField();


        Wolf wolf = new Wolf();
        gameField.addCell(wolf, 0, 1);

        Rabbit rabbit = new Rabbit();
        gameField.addCell(rabbit, 1, 2);

        Horse horse = new Horse();
        gameField.addCell(horse, 2, 3);

        for (int step = 0; step < 10; step++) {
            System.out.println("STEP " + step);
            List<Animal> animals = new ArrayList<>(gameField.getAllAnimals());
            for (Animal animal : animals) {
                animal.move(gameField);
            }
            printField(gameField.getCells());
        }
    }

    private static void printField(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print("cell[" + i + "," + j + "]");
                System.out.println(cells[i][j]);
            }
            System.out.println();
        }
    }
}
