package com.snakeandladder;
import java.util.*;

public class SnakeAndLadderUC5 {
    private static final int START_POSITION = 0;
    private static final int WINNING_POSITION = 100;
    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;

    public static void main(String[] args) {
        int currentPosition = START_POSITION;
        System.out.println("Welcome to Snake and Ladder Program");

        while (currentPosition < WINNING_POSITION) {
            int dieRoll = rollDie();
            int option = checkOption();

            System.out.println("Die rolled: " + dieRoll);
            System.out.println("Option: " + option);

            currentPosition = updatePosition(currentPosition, dieRoll, option);

            currentPosition = Math.max(currentPosition, START_POSITION);

            System.out.println("Player is at position: " + currentPosition);
        }

        System.out.println("Player reached the exact winning position: " + WINNING_POSITION);
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

        if (position > WINNING_POSITION) {
            position -= dieRoll;
        }
        position = Math.min(position, WINNING_POSITION);

        return position;
    }
}

