package com.brunosouza.cosmic.explorer.model;

public class Robot {
    private int x = 0;
    private int y = 0;
    private char direction = 'N'; // N, S, E, W

    public String executeCommands(String commands) {
        commands.chars()
                .mapToObj(command -> (char) command)
                .forEach(command -> executeCommand(command));

        return "(" + x + ", " + y + ", " + direction + ")";
    }

    private void executeCommand(char commandChar) {
        if (commandChar == 'M') {
            move();
        } else if (commandChar == 'L') {
            rotateLeft();
        } else if (commandChar == 'R') {
            rotateRight();
        } else {
            throw new IllegalArgumentException("invalid command");
        }
    }

    private void move() {
        int newX = x;
        int newY = y;

        if (direction == 'N') {
            newY++;
        } else if (direction == 'S') {
            newY--;
        } else if (direction == 'E') {
            newX++;
        } else if (direction == 'W') {
            newX--;
        }

        if (isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            throw new IllegalArgumentException("invalid position");
        }
    }

    private void rotateLeft() {
        if (direction == 'N') {
            direction = 'W';
        } else if (direction == 'S') {
            direction = 'E';
        } else if (direction == 'E') {
            direction = 'N';
        } else if (direction == 'W') {
            direction = 'S';
        }
    }

    private void rotateRight() {
        if (direction == 'N') {
            direction = 'E';
        } else if (direction == 'S') {
            direction = 'W';
        } else if (direction == 'E') {
            direction = 'S';
        } else if (direction == 'W') {
            direction = 'N';
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= 4 && y >= 0 && y <= 4;
    }
}

