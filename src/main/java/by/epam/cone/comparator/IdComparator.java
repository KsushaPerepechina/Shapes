package by.epam.cone.comparator;

import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class IdComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        long firstId = o1.getId();
        long secondId = o2.getId();
        return Long.compare(firstId, secondId);
    }
}
