package by.epam.cone.comparator;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        ConeAction coneAction = new ConeActionImpl();
        double volumeOfFirstCone = coneAction.calculateVolume(o1);
        double volumeOfSecondCone = coneAction.calculateVolume(o2);
        return Double.compare(volumeOfFirstCone, volumeOfSecondCone);
    }
}
