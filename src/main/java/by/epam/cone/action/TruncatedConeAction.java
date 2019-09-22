package by.epam.cone.action;

import by.epam.cone.entity.Cone;

public interface TruncatedConeAction {
    double calculateHeight(Cone cone);
    double calculateUpperCircleRadius(Cone cone);
    double calculateVolume(Cone cone);
}
