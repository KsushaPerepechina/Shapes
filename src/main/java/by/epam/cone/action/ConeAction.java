package by.epam.cone.action;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;

public interface ConeAction {
    double calculateFullSurfaceArea(Cone cone);
    double calculateVolume(Cone cone);
    double calculateVolumeOfTruncatedByCoordinatePlaneCone(Cone cone);
    boolean isStraightCircularCone(Cone cone) throws ConeException;
    boolean baseCircleBelongsToAnyCoordinatePlane(Cone cone);
    double calculateHeight(Cone cone);
    double calculateForming(Cone cone);
    double calculateBaseCircleLength(Cone cone);
    double calculateBaseCircleArea(Cone cone);
    double calculateLateralSurfaceArea(Cone cone);
    double calculateTruncatedConeHeight(Cone cone);
    double calculateTruncatedConeRadius(Cone cone);
    Point findCircleCenterOfTruncatedByCoordinatePlaneCone(Cone cone);
    boolean baseCircleIsParallelToXYPlane(Cone cone);
    boolean baseCircleIsParallelToXZPlane(Cone cone);
    boolean baseCircleIsParallelToYZPlane(Cone cone);
    boolean baseCircleBelongsToXYPlane(Cone cone);
    boolean baseCircleBelongsToXZPlane(Cone cone);
    boolean baseCircleBelongsToYZPlane(Cone cone);
    boolean isValid(Cone cone);
}