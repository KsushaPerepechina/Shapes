package by.epam.cone.generator;

public class IdGenerator {
    private static long ID = 0L;

    public static long generateId() {
        ++ID;
        return ID;
    }
}
