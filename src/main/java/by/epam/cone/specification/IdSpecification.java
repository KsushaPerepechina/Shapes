package by.epam.cone.specification;

import by.epam.cone.entity.Cone;

public class IdSpecification implements Specification<Cone> {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Cone object) {
        return id == object.getId();
    }
}
