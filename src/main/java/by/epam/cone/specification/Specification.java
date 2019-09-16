package by.epam.cone.specification;

public interface Specification<T> {
    boolean specified(T object);
}
