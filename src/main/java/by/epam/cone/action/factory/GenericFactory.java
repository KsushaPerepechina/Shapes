package by.epam.cone.action.factory;

import by.epam.cone.entity.Figure;

@FunctionalInterface
public interface GenericFactory<T extends Figure> {
    T create();
}
