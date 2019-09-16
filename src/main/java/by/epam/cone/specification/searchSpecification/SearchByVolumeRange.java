package by.epam.cone.specification.searchSpecification;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;
import by.epam.cone.specification.Specification;

public class SearchByVolumeRange implements Specification<Cone> {
    private double minVolume;
    private double maxVolume;
    private ConeAction coneAction = new ConeActionImpl();

    public SearchByVolumeRange(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Cone cone) {
        double volume = coneAction.calculateVolume(cone);
        return volume >= minVolume && volume <= maxVolume;
    }
}
