package by.epam.cone.specification;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

public class AreaRangeSpecification implements Specification<Cone> {
    private double minArea;
    private double maxArea;
    private ConeAction coneAction = new ConeActionImpl();

    public AreaRangeSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Cone cone) {
        double area = coneAction.calculateFullSurfaceArea(cone);
        return area >= minArea && area <= maxArea;
    }
}
