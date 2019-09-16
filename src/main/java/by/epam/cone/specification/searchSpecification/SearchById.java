package by.epam.cone.specification.searchSpecification;

import by.epam.cone.entity.Cone;
import by.epam.cone.specification.Specification;

public class SearchById implements Specification<Cone> {
    private long id;

    public SearchById(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Cone object) {
        return id == object.getId();
    }
}
