package by.epam.cone.action;

public interface ConeAction {
    double calculateLateralSurfaceArea(double radiusOfRotation, double forming);
    double calculateFullSurfaceArea(double radiusOfRotation, double forming);
    double calculateVolume(double radiusOfRotation, double height);
    double calculateBaseCircleLength(double radiusOfRotation);
    double calculateBaseCircleArea(double radiusOfRotation);
}