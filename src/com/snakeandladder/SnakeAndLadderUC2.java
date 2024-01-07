package com.snakeandladder;

import java.util.*;

public class SnakeAndLadderUC2 {
    private static final int START_POSITION = 0;

    public static void main(String[] args) {
        int currentPosition = START_POSITION;
        System.out.println("Welcome to Snake and Ladder Program");

        int dieRoll = rollDie();
        System.out.println("Die rolled: " + dieRoll);

        currentPosition += dieRoll;
        System.out.println("Player is at position: " + currentPosition);
    }

    private static int rollDie() {
        return (int) (Math.floor(Math.random() * 6) + 1);
    }
}
