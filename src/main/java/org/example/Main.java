package org.example;

import org.example.config.ApplicationContext;
import org.example.config.ApplicationLoader;
import org.example.model.map.Cell;
import org.example.model.map.GameField;
import org.example.model.organism.animal.herbivore.Rabbit;
import org.example.model.organism.animal.predator.Wolf;

public class Main {
    public static void main(String[] args) {
        ApplicationLoader loader = ApplicationLoader.getInstance();
        ApplicationContext context = loader.init(3, 3);
        GameField gameField = context.getGameField();

        Wolf wolf = new Wolf();
        gameField.addCell(wolf, 1, 1);

        Rabbit rabbit = new Rabbit();
        gameField.addCell(rabbit, 0, 2);

        Cell[][] cells = gameField.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                System.out.println("cell[" + i + "," + j + "]");
                System.out.println(cells[i][j]);
            }
        }
        System.out.println();
    }
}
