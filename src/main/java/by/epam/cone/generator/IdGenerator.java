package by.epam.cone.generator;

public class IdGenerator {
    private static long idCounter = 0L;

    public static long generateId() {
        return idCounter++;
    }
}