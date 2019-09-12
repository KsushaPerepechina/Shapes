package by.epam.cone.action.factory;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Figure;

public class GenericConeFactory implements GenericFactory<Figure> {
    @Override
    public Cone create() {
        return new Cone();
    }
}
