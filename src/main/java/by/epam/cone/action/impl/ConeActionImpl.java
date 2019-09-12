package by.epam.cone.action.impl;

import by.epam.cone.action.ConeAction;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class ConeActionImpl implements ConeAction {
    public double calculateLateralSurfaceArea(double radiusOfRotation, double forming) {
        return calculateBaseCircleLength(radiusOfRotation) * forming;
    }

    public double calculateFullSurfaceArea(double radiusOfRotation, double forming) {
        return calculateLateralSurfaceArea(radiusOfRotation, forming) + calculateBaseCircleArea(radiusOfRotation);
    }

    public double calculateVolume(double radiusOfRotation, double height) {
        return 1/3. * calculateBaseCircleArea(radiusOfRotation) * height;
    }

    public double calculateBaseCircleLength(double radiusOfRotation) {
        return 2 * PI * radiusOfRotation;
    }

    public double calculateBaseCircleArea(double radiusOfRotation) {
        return PI * pow(radiusOfRotation, 2);
    }
}
