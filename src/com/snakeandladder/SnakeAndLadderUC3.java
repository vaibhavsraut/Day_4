package com.snakeandladder;
import java.util.*;

public class SnakeAndLadderUC3 {
    private static final int START_POSITION = 0;
    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;

    public static void main(String[] args) {
        int currentPosition = START_POSITION;
        System.out.println("Welcome to Snake and Ladder Program");

        int dieRoll = rollDie();
        int option = checkOption();

        System.out.println("Die rolled: " + dieRoll);
        System.out.println("Option: " + option);

        currentPosition = updatePosition(currentPosition, dieRoll, option);

        System.out.println("Player is at position: " + currentPosition);
    }

    private static int rollDie() {
        return (int) (Math.floor(Math.random() * 6) + 1);
    }

    private static int checkOption() {
        return (int) (Math.floor(Math.random() * 3));
    }

    private static int updatePosition(int position, int dieRoll, int option) {
        switch (option) {
            case NO_PLAY:
                break;
            case LADDER:
                position += dieRoll;
                break;
            case SNAKE:
                position -= dieRoll;
                position = Math.max(position, START_POSITION);
                break;
        }
        return position;
    }
}

