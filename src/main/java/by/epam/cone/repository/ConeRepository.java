package by.epam.cone.repository;

import by.epam.cone.entity.Cone;
import by.epam.cone.specification.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class ConeRepository implements Repository<Cone> {

    private Set<Cone> data = new HashSet<>();

    @Override
    public void add(Cone cone) {
        data.add(cone);
    }

    @Override
    public void remove(Cone cone) {
        data.remove(cone);
    }

    @Override
    public void update(Cone cone) {
        data.forEach(o -> {
            if(o.getId() == cone.getId()) {
                data.remove(o);
            }
        });
        data.add(cone);
    }

    @Override
    public List<Cone> findBy(Specification specification) {
        return data.stream().
                filter(o -> specification.specified(o)).
                collect(Collectors.toList());
    }

    @Override
    public List<Cone> sortBy(Comparator comparator) {
        return data.stream().
                sorted((o1, o2) -> comparator.compare(o1, o2)).
                collect(Collectors.toList());
    }

}
