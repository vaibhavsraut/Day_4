package com.snakeandladder;
import java.util.*;

public class SnakeAndLadderUC7 {
    private static final int START_POSITION = 0;
    private static final int WINNING_POSITION = 100;
    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;

    public static void main(String[] args) {
        int player1Position = START_POSITION;
        int player2Position = START_POSITION;
        int currentPlayer = 1;
        int diceRollCount = 0;

        System.out.println("Welcome to Snake and Ladder Program");

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            int dieRoll = rollDie();
            int option = checkOption();

            diceRollCount++;

            System.out.println("Die rolled: " + dieRoll);
            System.out.println("Option: " + option);

            if (currentPlayer == 1) {
                player1Position = updatePosition(player1Position, dieRoll, option);
            } else {
                player2Position = updatePosition(player2Position, dieRoll, option);
            }

            player1Position = Math.max(player1Position, START_POSITION);
            player2Position = Math.max(player2Position, START_POSITION);

            System.out.println("Player 1 is at position: " + player1Position);
            System.out.println("Player 2 is at position: " + player2Position);

            if (option == LADDER) {
                System.out.println("Player " + currentPlayer + " got a Ladder and plays again!");
            } else {
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
        }

        if (player1Position >= WINNING_POSITION) {
            System.out.println("Player 1 won the game!");
        } else {
            System.out.println("Player 2 won the game!");
        }

        System.out.println("Number of times the dice was played to win the game: " + diceRollCount);
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

        position = Math.min(position, WINNING_POSITION);

        return position;
    }
}

