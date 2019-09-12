package by.epam.cone.entity;

import java.util.Objects;

public class Cone extends Figure {
    private Point top;
    private Point baseCircleCenter;
    private double radiusOfRotation;

    public Cone() {
    }

    public Cone(Point top, Point baseCircleCenter, double radiusOfRotation) {
        this.top = top;
        this.baseCircleCenter = baseCircleCenter;
        this.radiusOfRotation = radiusOfRotation;
    }

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        this.top = top;
    }

    public Point getBaseCircleCenter() {
        return baseCircleCenter;
    }

    public void setBaseCircleCenter(Point baseCircleCenter) {
        this.baseCircleCenter = baseCircleCenter;
    }

    public double getRadiusOfRotation() {
        return radiusOfRotation;
    }

    public void setRadiusOfRotation(double radiusOfRotation) {
        this.radiusOfRotation = radiusOfRotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radiusOfRotation, radiusOfRotation) == 0 &&
                top.equals(cone.top) &&
                baseCircleCenter.equals(cone.baseCircleCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, baseCircleCenter, radiusOfRotation);
    }

    @Override
    public String toString() {
        return "Cone{" +
                "top=" + top +
                ", baseCircleCenter=" + baseCircleCenter +
                ", radiusOfRotation=" + radiusOfRotation +
                '}';
    }
}
