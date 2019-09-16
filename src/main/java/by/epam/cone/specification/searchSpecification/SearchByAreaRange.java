package by.epam.cone.specification.searchSpecification;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;
import by.epam.cone.specification.Specification;

public class SearchByAreaRange implements Specification<Cone> {
    private double minArea;
    private double maxArea;
    private ConeAction coneAction = new ConeActionImpl();

    public SearchByAreaRange(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Cone cone) {
        double area = coneAction.calculateFullSurfaceArea(cone);
        return area >= minArea && area <= maxArea;
    }
}
