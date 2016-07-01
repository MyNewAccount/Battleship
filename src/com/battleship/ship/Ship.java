package com.battleship.ship;

public class Ship {
    private int shipStartX;
    private int shipStartY;
    private int length;
    private boolean isHorizontal;
    private int availableCellsInShip;

    public Ship(int shipStartX, int shipStartY, int length, boolean isHorizontal){
        this.shipStartX = shipStartX;
        this.shipStartY = shipStartY;
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.availableCellsInShip = length;
    }

    public int getShipStartX() { return this.shipStartX; }
    public int getShipStartY() { return this.shipStartY; }
    public int getLength() { return this.length; }
    public boolean getIsHorizontal() { return this.isHorizontal; }
    public int getAvailableCellsInShip() { return this.availableCellsInShip; }
    public void setAvailableCellsInShip(int nOfCells) { this.availableCellsInShip = nOfCells;}

    public void decreaseAvailableCellsInShip () { this.availableCellsInShip--;}

    public boolean isAlive(){
        return this.availableCellsInShip != 0 ? true : false;
    }
}
