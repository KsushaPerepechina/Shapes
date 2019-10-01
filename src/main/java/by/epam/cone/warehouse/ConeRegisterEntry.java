package by.epam.cone.warehouse;

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
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(area);
        result = prime * result + Double.hashCode(volume);
        return result;
    }
}
