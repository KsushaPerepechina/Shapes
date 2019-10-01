package by.epam.cone.action.impl;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.PointAction;
import by.epam.cone.action.TruncatedConeAction;
import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class TruncatedConeActionImpl implements TruncatedConeAction {

    public double calculateHeight(Cone cone) {
        PointAction pointAction = new PointActionImpl();
        return pointAction.calculateSegmentLength(cone.getBaseCircleCenter(), findUpperCircleCenter(cone));
    }

    public double calculateUpperCircleRadius(Cone cone) {
        ConeAction coneAction = new ConeActionImpl();
        double smallConeHeight = coneAction.calculateHeight(cone) - calculateHeight(cone);
        return (smallConeHeight * cone.getRadiusOfRotation()) / coneAction.calculateHeight(cone);
    }

    public double calculateVolume(Cone cone) {
        double lowerBaseRadius = cone.getRadiusOfRotation();
        double upperBaseRadius = calculateUpperCircleRadius(cone);
        return 1/3. * PI * calculateHeight(cone) * (pow(lowerBaseRadius, 2) + pow(upperBaseRadius, 2) + lowerBaseRadius * upperBaseRadius);
    }

    private Point findUpperCircleCenter(Cone cone) {
        Point top = cone.getTop();
        Point center = cone.getBaseCircleCenter();
        double x = (top.getCoordinateX() == center.getCoordinateX()) ? top.getCoordinateX() : 0;
        double y = (top.getCoordinateY() == center.getCoordinateY()) ? top.getCoordinateY() : 0;
        double z = (top.getCoordinateZ() == center.getCoordinateZ()) ? top.getCoordinateZ() : 0;
        return new Point(x, y, z);
    }
}
