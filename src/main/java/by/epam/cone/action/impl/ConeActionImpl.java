package by.epam.cone.action.impl;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.PointAction;
import by.epam.cone.entity.Cone;

import static java.lang.Math.*;

public class ConeActionImpl implements ConeAction {
    private PointAction pointAction = new PointActionImpl();

    public double calculateBaseCircleLength(Cone cone) {
        return 2 * PI * cone.getRadiusOfRotation();
    }

    public double calculateBaseCircleArea(Cone cone) {
        return PI * pow(cone.getRadiusOfRotation(), 2);
    }

    public double calculateHeight(Cone cone) {
        return pointAction.calculateSegmentLength(cone.getTop(), cone.getBaseCircleCenter());
    }

    public double calculateForming(Cone cone) {
        return hypot(cone.getRadiusOfRotation(), calculateHeight(cone));
    }

    public double calculateLateralSurfaceArea(Cone cone) {
        return calculateBaseCircleLength(cone) * calculateForming(cone);
    }

    public double calculateFullSurfaceArea(Cone cone) {
        return calculateLateralSurfaceArea(cone) + calculateBaseCircleArea(cone);
    }

    public double calculateVolume(Cone cone) {
        return 1/3. * calculateBaseCircleArea(cone) * calculateHeight(cone);
    }

    public boolean isStraightCircularCone(Cone cone) {
        return baseCircleIsParallelToXYPlane(cone) || baseCircleIsParallelToXZPlane(cone) || baseCircleIsParallelToYZPlane(cone);
    }

    public boolean baseCircleBelongsToAnyCoordinatePlane(Cone cone) {
        return baseCircleBelongsToXYPlane(cone) || baseCircleBelongsToYZPlane(cone) || baseCircleBelongsToXZPlane(cone);
    }

    private boolean baseCircleIsParallelToXYPlane(Cone cone) {
        return cone.getTop().getCoordinateX() == cone.getBaseCircleCenter().getCoordinateX() &&
                cone.getTop().getCoordinateY() == cone.getBaseCircleCenter().getCoordinateY() ;
    }

    private boolean baseCircleIsParallelToXZPlane(Cone cone) {
        return cone.getTop().getCoordinateX() == cone.getBaseCircleCenter().getCoordinateX() &&
                cone.getTop().getCoordinateZ() == cone.getBaseCircleCenter().getCoordinateZ() ;
    }

    private boolean baseCircleIsParallelToYZPlane(Cone cone) {
        return cone.getTop().getCoordinateZ() == cone.getBaseCircleCenter().getCoordinateZ() &&
                cone.getTop().getCoordinateY() == cone.getBaseCircleCenter().getCoordinateY() ;
    }

    private boolean baseCircleBelongsToXYPlane(Cone cone) {
        return cone.getBaseCircleCenter().getCoordinateZ() == 0;
    }

    private boolean baseCircleBelongsToXZPlane(Cone cone) {
        return cone.getBaseCircleCenter().getCoordinateY() == 0;
    }

    private boolean baseCircleBelongsToYZPlane(Cone cone) {
        return cone.getBaseCircleCenter().getCoordinateX() == 0;
    }

}
