package com.twu.refactoring;

/**
 * Created by jbealle on 10/18/16.
 */



public enum Direction {
    NORTH {
        @Override
        public Direction turnRight(){
            return EAST;
        }
        @Override
        public Direction turnLeft(){
            return WEST;
        }
    },
    SOUTH {
        @Override
        public Direction turnRight(){
            return WEST;
        }
        @Override
        public Direction turnLeft(){
            return EAST;
        }
    },
    EAST {
        @Override
        public Direction turnRight(){
            return SOUTH;
        }
        @Override
        public Direction turnLeft(){
            return NORTH;
        }
    },
    WEST {
        @Override
        public Direction turnRight(){
            return NORTH;
        }
        @Override
        public Direction turnLeft(){
            return SOUTH;
        }
    };

    public Direction turnRight(){return null;}
    public Direction turnLeft(){return null;}


//
//    @Override
//    public String toString() {
//        return "Direction{direction=" +  + '}';
//    }
}

