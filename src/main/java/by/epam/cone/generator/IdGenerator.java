package by.epam.cone.generator;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static AtomicLong idCounter = new AtomicLong();

    public static long generateId() {
        return idCounter.getAndIncrement();
    }
}