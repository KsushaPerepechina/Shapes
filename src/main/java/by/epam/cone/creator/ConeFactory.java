package by.epam.cone.creator;

import by.epam.cone.entity.Cone;

public class ConeFactory implements GenericFigureFactory<Cone> {
    @Override
    public Cone create() {
        return new Cone();
    }
}
