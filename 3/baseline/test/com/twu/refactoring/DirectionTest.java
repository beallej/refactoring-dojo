package com.twu.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @Before
    public void setUp() throws Exception {
        north =  Direction.NORTH;
        east =  Direction.EAST;
    }

    @Test
    public void shouldTurnEastWhenTurnRightFromNorth() {
        Direction east2 = north.turnRight();
        assertEquals(east2, Direction.EAST);
    }

    @Test
    public void shouldTurnWestWhenTurnLeftFromNorth() {
        Direction west = north.turnLeft();
        assertEquals(west, Direction.WEST);
    }

    @Test
    public void shouldTurnNorthWhenTurnLeftFromEast() {
        Direction north2 = east.turnLeft();
        assertEquals(north2, north);
    }
}
