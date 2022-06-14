package org.europa.together.keywords;

public class Dimension {

    private int x;
    private int y;

    public Dimension(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Dimension{" + "x=" + x + ", y=" + y + '}';
    }
}
