package by.epam.cone.action;

import by.epam.cone.entity.Cone;

public interface ConeAction {
    double calculateHeight(Cone cone);
    double calculateForming(Cone cone);
    double calculateBaseCircleLength(Cone cone);
    double calculateBaseCircleArea(Cone cone);
    double calculateLateralSurfaceArea(Cone cone);
    double calculateFullSurfaceArea(Cone cone);
    double calculateVolume(Cone cone);
    boolean isStraightCircularCone(Cone cone);
    boolean baseCircleBelongsToAnyCoordinatePlane(Cone cone);
}