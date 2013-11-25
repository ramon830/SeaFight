package com.seafight;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.11.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public class BattleField {
    private List<Ship> ships;
    private List<Shot> shots;

    public void placeShip(Ship ship, int x, int y) {
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Shot> getShots() {
        return shots;
    }

    public void makeShot(int x, int y) {
    }

    public boolean isDefeat() {
        return false;
    }
}
