package by.epam.cone.comparator;

import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class idComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        long first_id = o1.getId();
        long second_id = o2.getId();
        return Long.compare(first_id, second_id);
    }
}
