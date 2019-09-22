package by.epam.cone.warehouse;

import java.util.Objects;

public class ConeRegisterEntry {
    private double area;
    private double volume;

    public ConeRegisterEntry(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConeRegisterEntry that = (ConeRegisterEntry) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, volume);
    }
}