package com.seafight;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.11.13
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public class Ship {
    private int length;
    private int x;
    private int y;
    private boolean verticalOrientation;
    private int wounds = 0;

    public Ship(int length, int x, int y, boolean verticalOrientation) {
        this.length = length;
        this.x = x;
        this.y = y;
        this.verticalOrientation = verticalOrientation;
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
        wounds++;
    }

    public boolean isDestroyed() {
        if (wounds == length) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isVerticalOrientation() {
        return verticalOrientation;
    }
}
