package org.example.model;

public class Location {
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public  double distance(Location other){
        double dx=other.x-x;
        double dy=other.y-y;
        return Math.sqrt((dx*dx) + (dy*dy));
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
