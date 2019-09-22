package by.epam.cone.comparator;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class volumeComparator implements Comparator<Cone> {
    private ConeAction coneAction = new ConeActionImpl();

    @Override
    public int compare(Cone o1, Cone o2) {
        double volumeOfFirstCone = coneAction.calculateVolume(o1);
        double volumeOfSecondCone = coneAction.calculateVolume(o2);
        return Double.compare(volumeOfFirstCone, volumeOfSecondCone);
    }
}
