package by.epam.cone.specification.sortSpecification;

import by.epam.cone.entity.Cone;

import java.util.Comparator;

public class SortById implements Comparator<Cone> {
    private static final int LARGER = 1;
    private static final int LESS = -1;
    private static final int EQUALS = 0;

    @Override
    public int compare(Cone o1, Cone o2) {
        long first_id = o1.getId();
        long second_id = o2.getId();

        if (first_id < second_id) {
            return LESS;
        } else if (first_id == second_id) {
            return EQUALS;
        } else {
            return LARGER;
        }
    }
}
