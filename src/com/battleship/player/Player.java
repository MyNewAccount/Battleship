package com.battleship.player;

import com.battleship.map.Map;
import com.battleship.ship.Ship;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private String name;
    private Map ownMap;
    private Map enemyMap;
    private int numberOfShips;
    private List<Ship> list = new LinkedList<>();

    public Player(){
        this.ownMap = new Map();
        this.enemyMap = new Map();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfShips() { return this.numberOfShips; }

    public void setNumberOfShips(int numberOfShips) { this.numberOfShips = numberOfShips; }

    public void setName(String name) {
        this.name = name;
    }

    protected Map getOwnMap(){
        return ownMap;
    }

    protected Map getEnemyMap(){
        return enemyMap;
    }

    public List<Ship> getShipList(){ return this.list; }

    public boolean isHit(int positionX, int positionY){
        boolean hit = this.getOwnMap().isHit(positionX, positionY);
        this.getOwnMap().markShot(positionX, positionY, hit);
        return hit;
    }

    public void markFeedback(int positionX, int positionY, boolean hit){
        this.getEnemyMap().markShot(positionX, positionY, hit);
    }

    public void placeShip(int startPositionX, int startPositionY, int length, boolean isHorizontal) {
        list.add(new Ship(startPositionX, startPositionY, length, isHorizontal));
        this.getOwnMap().setShip(startPositionX, startPositionY, length, isHorizontal);
    }

    public void lookAtMaps() {
        System.out.println("YOUR MAP:");
        this.getOwnMap().printMatrix();
        System.out.println("ENEMY MAP:");
        this.getEnemyMap().printMatrix();
    }

    public Ship getShipByCoordinates(int coordinateX, int coordinateY) {
        Ship shipToFind = null;
        Map map = getOwnMap();

        // probably will need to check whether a cell has 1
        for (Ship ship : list){
            if (ship.getShipStartX() == coordinateX && ship.getAvailableCellsInShip() != 0) {
                if (coordinateY >= ship.getShipStartY() && coordinateY < ship.getShipStartY()+ship.getLength()) {
                    shipToFind = ship;
                    break;
                }
            }
        }
        return shipToFind;
    }

    public void maskShipAsHit(int coordinateX, int coordinateY) {
        Ship ship = getShipByCoordinates(coordinateX, coordinateY);
        ship.decreaseAvailableCellsInShip();
        if (!ship.isAlive()) {
            //to find out how to delete killed ship from the list
            this.numberOfShips--;
            System.out.println("Ship is killed");
        }
    }

}
