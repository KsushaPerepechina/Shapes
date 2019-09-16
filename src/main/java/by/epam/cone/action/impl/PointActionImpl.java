package by.epam.cone.action.impl;

import by.epam.cone.action.PointAction;
import by.epam.cone.entity.Point;

import static java.lang.StrictMath.hypot;

public class PointActionImpl implements PointAction {
    public double calculateSegmentLength(Point a, Point b) {
        double delX = a.getCoordinateX() - b.getCoordinateX();
        double delY = a.getCoordinateY() - b.getCoordinateY();
        double delZ = a.getCoordinateZ() - b.getCoordinateZ();
        return hypot(delX, hypot(delY, delZ));
    }
}
