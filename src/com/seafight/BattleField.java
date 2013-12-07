package com.seafight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleField {
    private List<Ship> ships = new ArrayList<Ship>();
    private List<Shot> shots = new ArrayList<Shot>();


    public void placeShip(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Shot> getShots() {
        return shots;
    }

    public boolean makeShot(int x, int y) {
        shots.add(new Shot(x, y));
        for (Ship ship : ships) {

            int x1;
            int x2;
            int y1;
            int y2;
            if (ship.isVerticalOrientation()) {
                x1 = ship.getX();
                x2 = ship.getX();
                y1 = ship.getY();
                y2 = ship.getY() + ship.getLength() - 1;
            } else {
                x1 = ship.getX();
                x2 = ship.getX() + ship.getLength() - 1;
                y1 = ship.getY();
                y2 = ship.getY();
            }

            int a1 = x1 - x;
            int a2 = y1 - y;
            int b1 = x2 - x;
            int b2 = y2 - y;


            if (((x - x1) * (y2 - y1) - (x2 - x1) * (y - y1)) == 0 && (a1 * b1 + a2 * b2) <= 0) {
                ship.makeWound(new Shot(x, y));
                return true;
            }

        }

        return false;
    }

    public boolean isDefeat() {
        int s = 0;
        for (Ship ship : ships) {
            if (ship.isDestroyed()) {
                s++;
            }
        }

        return s == ships.size() ? true : false;
    }

    public void computerPlaceShip() {

        final int SIZE_FIELD = 10;
        boolean[][] field = new boolean[SIZE_FIELD][SIZE_FIELD];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = false;
            }
        }
        int[] sizeShips = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        for (int sizeShip : sizeShips) {
            boolean out;
            do {
                out = false;
                Random generator = new Random();
                int x = generator.nextInt(10);
                int y = generator.nextInt(10);
                boolean verticalOrientation = generator.nextBoolean();
                if ((x + sizeShip) > field.length || (y + sizeShip) > field.length) {
                    out = true;
                    continue;
                }

                int x1, x2;
                int y1, y2;

                if (verticalOrientation) {
                    x1 = x - 1;
                    x2 = x + 1;
                    y1 = y - 1;
                    y2 = y + sizeShip + 1;
                } else {
                    x1 = x - 1;
                    x2 = x + sizeShip + 1;
                    y1 = y - 1;
                    y2 = y + 1;
                }
                for (int i = x1; i <= x2; i++) {
                    for (int j = y1; j <= y2; j++) {

                        if (i >= 0 && i < field.length && j >= 0 && j < field.length) {
                            if (field[j][i]) {
                                out = true;

                            }
                        }
                    }
                }
                if (!out) {
                    if (verticalOrientation) {
                        for (int i = y; i < y + sizeShip; i++) {
                            field[i][x] = true;
                        }
                    } else {
                        for (int i = x; i < x + sizeShip; i++) {
                            field[y][i] = true;
                        }
                    }
                    placeShip(new Ship(sizeShip, x, y, verticalOrientation));

                }


            }
            while (out);

        }
    }

    public void computerShots() {
        final int SIZE_FIELD = 10;
        boolean[][] field = new boolean[SIZE_FIELD][SIZE_FIELD];
        boolean wound = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = false;
            }
        }

        for (Ship ship : ships) {
            if (ship.isDestroyed()) {
                int x1, x2;
                int y1, y2;

                if (ship.isVerticalOrientation()) {
                    x1 = ship.getX() - 1;
                    x2 = ship.getX() + 1;
                    y1 = ship.getY() - 1;
                    y2 = ship.getY() + ship.getLength();
                } else {
                    x1 = ship.getX() - 1;
                    x2 = ship.getX() + ship.getLength();
                    y1 = ship.getY() - 1;
                    y2 = ship.getY() + 1;
                }

                for (int i = x1; i <= x2; i++) {
                    for (int j = y1; j <= y2; j++) {

                        if (i >= 0 && i < field.length && j >= 0 && j < field.length) {
                            field[j][i] = true;


                        }
                    }
                }
            }

        }

        for (Shot shot : shots) {
            field[shot.getY()][shot.getX()] = true;
        }

        for (Ship ship : ships) {
            if (ship.isDestroyed() != true && ship.getWounds().size() > 0) {
                wound = true;
            }
        }

        if (!wound) {

        }

        if (makeShot(x, y)) {
            computerShots();
        }

    }


}
