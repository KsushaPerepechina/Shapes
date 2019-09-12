package by.epam.cone.action.impl;

import by.epam.cone.action.PointAction;

import static java.lang.StrictMath.pow;

public class PointActionImpl implements PointAction {
    public double calculateSegmentLength(double xA, double yA, double zA, double xB, double yB, double zB) {
        return Math.sqrt(pow((xB - xA), 2) + pow((yB - yA), 2) + pow((xB - zA), 2));
    }
}
