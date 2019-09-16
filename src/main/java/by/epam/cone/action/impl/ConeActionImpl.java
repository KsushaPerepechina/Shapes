package by.epam.cone.action.impl;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.PointAction;
import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;

import static java.lang.Math.*;

public class ConeActionImpl implements ConeAction {
    private PointAction pointAction = new PointActionImpl();

    public double calculateFullSurfaceArea(Cone cone) {
        return calculateLateralSurfaceArea(cone) + calculateBaseCircleArea(cone);
    }

    public double calculateVolume(Cone cone) {
        return 1/3. * calculateBaseCircleArea(cone) * calculateHeight(cone);
    }

    public double calculateVolumeOfTruncatedByCoordinatePlaneCone(Cone cone) {
        double lowerBaseRadius = cone.getRadiusOfRotation();
        double upperBaseRadius = calculateTruncatedConeRadius(cone);
        return 1/3. * PI * calculateTruncatedConeHeight(cone) * (pow(lowerBaseRadius, 2) + pow(upperBaseRadius, 2) + lowerBaseRadius * upperBaseRadius);
    }

    public boolean isStraightCircularCone(Cone cone) throws ConeException {
        if (!isValid(cone)) {
            throw new ConeException("Figure includes invalid value of parameters");
        }
        return baseCircleIsParallelToXYPlane(cone) || baseCircleIsParallelToXZPlane(cone) || baseCircleIsParallelToYZPlane(cone);
    }

    public boolean baseCircleBelongsToAnyCoordinatePlane(Cone cone) {
        return baseCircleBelongsToXYPlane(cone) || baseCircleBelongsToYZPlane(cone) || baseCircleBelongsToXZPlane(cone);
    }

    public double calculateHeight(Cone cone) {
        return pointAction.calculateSegmentLength(cone.getTop(), cone.getBaseCircleCenter());
    }

    public double calculateForming(Cone cone) {
        return hypot(cone.getRadiusOfRotation(), calculateHeight(cone));
    }

    public double calculateBaseCircleLength(Cone cone) {
        return 2 * PI * cone.getRadiusOfRotation();
    }

    public double calculateBaseCircleArea(Cone cone) {
        return PI * pow(cone.getRadiusOfRotation(), 2);
    }

    public double calculateLateralSurfaceArea(Cone cone) {
        return calculateBaseCircleLength(cone) * calculateForming(cone);
    }

    public double calculateTruncatedConeHeight(Cone cone) {
        return pointAction.calculateSegmentLength(cone.getBaseCircleCenter(), findCircleCenterOfTruncatedByCoordinatePlaneCone(cone));
    }

    public double calculateTruncatedConeRadius(Cone cone) {
        return (calculateTruncatedConeHeight(cone) * cone.getRadiusOfRotation()) / calculateHeight(cone);
    }

    public Point findCircleCenterOfTruncatedByCoordinatePlaneCone(Cone cone) {
        Point top = cone.getTop();
        Point center = cone.getBaseCircleCenter();
        double x = (top.getCoordinateX() == center.getCoordinateX()) ? top.getCoordinateX() : 0;
        double y = (top.getCoordinateY() == center.getCoordinateY()) ? top.getCoordinateY() : 0;
        double z = (top.getCoordinateZ() == center.getCoordinateZ()) ? top.getCoordinateZ() : 0;
        return new Point(x, y, z);
    }

    public boolean baseCircleIsParallelToXYPlane(Cone cone) {
        return cone.getTop().getCoordinateX() == cone.getBaseCircleCenter().getCoordinateX() &&
                cone.getTop().getCoordinateY() == cone.getBaseCircleCenter().getCoordinateY() ;
    }

    public boolean baseCircleIsParallelToXZPlane(Cone cone) {
        return cone.getTop().getCoordinateX() == cone.getBaseCircleCenter().getCoordinateX() &&
                cone.getTop().getCoordinateZ() == cone.getBaseCircleCenter().getCoordinateZ() ;
    }

    public boolean baseCircleIsParallelToYZPlane(Cone cone) {
        return cone.getTop().getCoordinateZ() == cone.getBaseCircleCenter().getCoordinateZ() &&
                cone.getTop().getCoordinateY() == cone.getBaseCircleCenter().getCoordinateY() ;
    }

    public boolean baseCircleBelongsToXYPlane(Cone cone) {
        return cone.getBaseCircleCenter().getCoordinateZ() == 0;
    }

    public boolean baseCircleBelongsToXZPlane(Cone cone) {
        return cone.getBaseCircleCenter().getCoordinateY() == 0;
    }

    public boolean baseCircleBelongsToYZPlane(Cone cone) {
        return cone.getBaseCircleCenter().getCoordinateX() == 0;
    }

    public boolean isValid(Cone cone) {
        return cone.getRadiusOfRotation() > 0 && cone.getTop().equals(cone.getBaseCircleCenter());
    }
}
