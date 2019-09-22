package by.epam.cone.repository;

import by.epam.cone.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T object);
    void remove(T object);
    void update(T object);
    List<T> findBy(Specification specification);
    List<T> sortBy(Comparator comparator);
}
