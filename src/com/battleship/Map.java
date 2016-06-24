package com.battleship;

/**
 * Created by Irka on 6/24/2016.
 */
public class Map {

    private int[][] matrix;

    /**
     * creating a Map object by creating a matrix with 10x10 dimenshion
     */
    public Map(){
        this.matrix = new int[10][10];
    }

    /**
     * drawing created Map.
     * If a ship is located on the map, it will be shown as 'X' symbol.
     */
    public void drawMap(){
        for (int row = 0; row < matrix.length; row++){
            for (int count = 0; count < matrix[row].length; count++){
                System.out.print("----");
            }
            System.out.println();
            System.out.print('|');
            for (int column = 0; column < matrix[row].length; column++){
                if (matrix[row][column] == 1)
                    System.out.print('X' + " | ");
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
    public void setShip(int startPositionX, int startPositionY, int shipLength, boolean isHorizontal){
        //to do
    }

    /**
     * reducing possible ship location when a ship is not alive.
     * For example, a ship with length 1 is located on map with coordinates(2,2). It means that no ships will be located on the borders
     * of drowned ship, i.e. no ships on the followinf coordinates ({1,1}, {1,2}, {1,3}, {2,1}, {2,3}, {3,1}, {3,2}, {3,3}).
     */
    public void reduceShipLocationArea() {
        //to do
    }
}
