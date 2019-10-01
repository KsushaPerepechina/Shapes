package by.epam.cone.comparator;

import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        double radiusOfFirstCone = o1.getRadiusOfRotation();
        double radiusOfSecondCone = o2.getRadiusOfRotation();
        return Double.compare(radiusOfFirstCone, radiusOfSecondCone);
    }
}
