package by.epam.cone.specification;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

public class VolumeLowerBoundSpecification implements Specification<Cone> {
    private double volume;
    private ConeAction coneAction = new ConeActionImpl();

    public VolumeLowerBoundSpecification(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Cone cone) {
        double currentVolume = coneAction.calculateVolume(cone);
        return currentVolume > volume;
    }
}
