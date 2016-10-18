package com.twu.refactoring;

import java.util.HashMap;
import java.util.Map;

public class Direction {
    private final char direction;
    private final Map<Direction, Direction> rightTurns;

    public Direction(char direction) {
        this.direction = direction;
        rightTurns = new HashMap<>(4);
        rightTurns.put(new Direction('N'), new Direction('E'));
        rightTurns.put(new Direction('S'), new Direction('W'));
        rightTurns.put(new Direction('E'), new Direction('N'));
        rightTurns.put(new Direction('W'), new Direction('S'));


    }

    public Direction turnRight() {
        switch (direction) {
            case 'N':
                return new Direction('E');
            case 'S':
                return new Direction('W');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        switch (direction) {
            case 'N':
                return new Direction('W');
            case 'S':
                return new Direction('E');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
