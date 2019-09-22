package by.epam.cone.creator;

@FunctionalInterface
public interface GenericFigureFactory<T> {
    T create();
}