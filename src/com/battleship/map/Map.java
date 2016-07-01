package com.battleship.map;

public class Map {

    private static final int NOTHING = 0;
    private static final int SHIP = 1;
    private static final int HIT = 2;
    private static final int MISS = -1;

    private int[][] matrix;

    /**
     * creating a Map object by creating a matrix with 10x10 dimenshion
     */
    public Map(){
        this.matrix = new int[10][10];
    }

    public void setMap(int positionX, int positionY, int value){
        this.matrix[positionX][positionY] = value;
    }

    public void setShip(int startPositionX, int startPositionY, int length, boolean isHorizontal){
        if(isHorizontal){
            for (int i = startPositionY; i < startPositionY+length; i++)
                matrix[startPositionX][i] = SHIP;
        } else {
            for (int j = startPositionX; j < startPositionX+length; j++)
                matrix[j][startPositionY] = SHIP;
        }
    }

    public boolean isHit(int positionX, int positionY){
        boolean hit = false;
        if (matrix[positionX][positionY] == SHIP) {
            hit = true;
        }
        return hit;
    }

    public void markShot(int positionX, int positionY, boolean hit) {
        if (hit) {
            setMap(positionX, positionY, HIT);
        } else {
            setMap(positionX, positionY, MISS);
        }
    }

    /**
     * drawing created Map.
     * If a ship is located on the matrix, it will be shown as 'X' symbol.
     */
    public void printMatrix(){
        for (int row = 0; row < matrix.length; row++){
            for (int count = 0; count < matrix[row].length; count++){
                System.out.print("----");
            }
            System.out.println();
            System.out.print('|');
            for (int column = 0; column < matrix[row].length; column++){
                if (matrix[row][column] == SHIP)
                    System.out.print('X' + " | ");
                else if (matrix[row][column] == HIT)
                    System.out.print('+' + " | ");
                else if (matrix[row][column] == MISS)
                    System.out.print('*' + " | ");
                else
                    System.out.print(" " + " | ");
            }
            System.out.println();
        }
    }

    /**
     * setShip is used to locate a ship according to its coordinates and number od cell the ship requires
     * @param startPositionX - X-coordinate where the first cell of the ship will be located
     * @param startPositionY - Y-coordinate where the first cell of the ship will be located
     * @param shipLength - how many cells a ship requires
     * @param isHorizontal - whether the ship will be located horizontally or vertically
     */


    /**
     * reducing possible ship location when a ship is not alive.
     * For example, a ship with length 1 is located on matrix with coordinates(2,2). It means that no ships will be located on the borders
     * of drowned ship, i.e. no ships on the followinf coordinates ({1,1}, {1,2}, {1,3}, {2,1}, {2,3}, {3,1}, {3,2}, {3,3}).
     */
}
