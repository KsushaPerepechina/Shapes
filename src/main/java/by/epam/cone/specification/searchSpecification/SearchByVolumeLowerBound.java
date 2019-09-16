package by.epam.cone.specification.searchSpecification;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;
import by.epam.cone.specification.Specification;

public class SearchByVolumeLowerBound implements Specification<Cone> {
    private double volume;
    private ConeAction coneAction = new ConeActionImpl();

    public SearchByVolumeLowerBound(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Cone cone) {
        double currentVolume = coneAction.calculateVolume(cone);
        return currentVolume > volume;
    }
}
