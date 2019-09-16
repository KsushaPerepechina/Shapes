package by.epam.cone.specification.sortSpecification;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class SortByVolume implements Comparator<Cone> {
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;
    private ConeAction coneAction = new ConeActionImpl();

    @Override
    public int compare(Cone o1, Cone o2) {
        double volumeOfFirstCone = coneAction.calculateVolume(o1);
        double volumeOfSecondCone = coneAction.calculateVolume(o2);

        if (volumeOfFirstCone < volumeOfSecondCone) {
            return LESS;
        } else if (volumeOfFirstCone == volumeOfSecondCone) {
            return EQUALS;
        } else {
            return LARGER;
        }
    }
}
