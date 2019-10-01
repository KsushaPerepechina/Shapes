package by.epam.cone.entity;

import java.util.StringJoiner;

public class Point {
    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;

    public Point() {
    }

    public Point(double coordinateX, double coordinateY, double coordinateZ) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(double coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.coordinateX, coordinateX) == 0 &&
                Double.compare(point.coordinateY, coordinateY) == 0 &&
                Double.compare(point.coordinateZ, coordinateZ) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(coordinateX);
        result = prime * result + Double.hashCode(coordinateY);
        result = prime * result + Double.hashCode(coordinateZ);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("coordinateX=" + coordinateX)
                .add("coordinateY=" + coordinateY)
                .add("coordinateZ=" + coordinateZ)
                .toString();
    }
}
