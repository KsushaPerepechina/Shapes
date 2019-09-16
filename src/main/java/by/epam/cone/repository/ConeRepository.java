package by.epam.cone.repository;

import by.epam.cone.entity.Cone;
import by.epam.cone.specification.Specification;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConeRepository implements Repository<Cone> {

    private Map<Long, Cone> data = new HashMap<>();

    @Override
    public void add(Cone cone) {
        data.put(cone.getId(), cone);
    }

    @Override
    public void remove(Cone object) {
        data.remove(object.getId(), object);
    }

    @Override
    public void update(Cone object) {
        for (Map.Entry<Long, Cone> record : data.entrySet()) {
            if (record.getKey().equals(object.getId())) {
                data.put(object.getId(), object);
            }
        }
    }

    @Override
    public List<Cone> findBy(Specification specification) {
        return data.values().stream().
                filter(o -> specification.specified(o)).
                collect(Collectors.toList());
    }

    @Override
    public List<Cone> sortBy(Comparator comparator) {
        return data.values().stream().
                sorted((t1, t2) -> comparator.compare(t1, t2)).
                collect(Collectors.toList());
    }

}
