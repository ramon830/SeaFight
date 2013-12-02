package com.seafight;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int length;
    private int x;
    private int y;
    private boolean verticalOrientation;
    private List<Shot> wounds = new ArrayList<Shot>();

    public Ship(int length, int x, int y, boolean verticalOrientation) {
        this.length = length;
        this.x = x;
        this.y = y;
        this.verticalOrientation = verticalOrientation;
    }

    public List<Shot> getWounds() {
        return wounds;
    }

    public int getLength() {
        return length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void makeWound(Shot shot) {
        wounds.add(shot);

    }

    public boolean isDestroyed() {

        if (wounds.size() == length) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isVerticalOrientation() {
        return verticalOrientation;
    }
}
