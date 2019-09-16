package by.epam.cone.specification.sortSpecification;

import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class SortByRadius implements Comparator<Cone> {
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;

    @Override
    public int compare(Cone o1, Cone o2) {
        double radiusOfFirstCone = o1.getRadiusOfRotation();
        double radiusOfSecondCone = o2.getRadiusOfRotation();

        if (radiusOfFirstCone < radiusOfSecondCone) {
            return LESS;
        } else if (radiusOfFirstCone == radiusOfSecondCone) {
            return EQUALS;
        } else {
            return LARGER;
        }
    }
}
