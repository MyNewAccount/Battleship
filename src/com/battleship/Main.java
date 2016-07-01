package com.battleship;

import com.battleship.player.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numberofShips = in.nextInt();

        Player player1 = new Player();
        player1.setName("Player 1");

        player1.placeShip(2, 3, 2, false);
        player1.placeShip(1, 5, 4, true);
        player1.placeShip(0, 1, 3, false);
        player1.placeShip(5, 6, 3, true);

        player1.setNumberOfShips(numberofShips);

        Player player2 = new Player();
        player2.setName("Player 2");

        player2.placeShip(2, 3, 4, true);
        player2.placeShip(4, 2, 3, false);
        player2.placeShip(3, 8, 2, true);
        player2.placeShip(4, 5, 1, true);

        player2.setNumberOfShips(numberofShips);

        boolean hit = false;

        do {
            hit = doTurn(player1, player2);
            if (hit){
                do {
                    doTurn(player1, player2);
                }while (hit);
            }
            hit = doTurn(player2, player1);
            if (hit){
                do {
                    doTurn(player2, player1);
                } while (hit);
            }
        } while (numberofShips > 0);
    }

    public static boolean doTurn(Player active, Player other) {
        System.out.println("It's your turn, " + active.getName() + " !");
        active.lookAtMaps();
        System.out.println("Shoot! (enter coordinates)");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        boolean hit = other.isHit(x, y);
        System.out.println(hit ? "HIT !!!" : "MISS!");
        if(hit) {
            other.maskShipAsHit(x, y);
        }
        active.markFeedback(x, y, hit);
        return  hit;
    }
}
