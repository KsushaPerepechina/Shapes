package by.epam.cone.creator;

import by.epam.cone.entity.Cone;

public class GenericConeFactory implements GenericFigureFactory<Figure> {
    @Override
    public Cone create() {
        return new Cone();
    }
}
