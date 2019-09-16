package by.epam.cone.entity;

import by.epam.cone.generator.IdGenerator;
import by.epam.cone.observer.ConeEvent;
import by.epam.cone.observer.Observable;
import by.epam.cone.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Cone implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private long id;
    private Point top;
    private Point baseCircleCenter;
    private double radiusOfRotation;

    public Cone() {
    }

    public Cone(Point top, Point baseCircleCenter, double radiusOfRotation) {
        this.top = top;
        this.baseCircleCenter = baseCircleCenter;
        this.radiusOfRotation = radiusOfRotation;
        this.id = IdGenerator.generateId();
        notifyAllObservers();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyAllObservers();
    }

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        this.top = top;
        notifyAllObservers();
    }

    public Point getBaseCircleCenter() {
        return baseCircleCenter;
    }

    public void setBaseCircleCenter(Point baseCircleCenter) {
        this.baseCircleCenter = baseCircleCenter;
        notifyAllObservers();
    }

    public double getRadiusOfRotation() {
        return radiusOfRotation;
    }

    public void setRadiusOfRotation(double radiusOfRotation) {
        this.radiusOfRotation = radiusOfRotation;
        notifyAllObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radiusOfRotation, radiusOfRotation) == 0 &&
                top.equals(cone.top) &&
                baseCircleCenter.equals(cone.baseCircleCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, baseCircleCenter, radiusOfRotation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cone.class.getSimpleName() + "[", "]")
                .add("top=" + top)
                .add("baseCircleCenter=" + baseCircleCenter)
                .add("radiusOfRotation=" + radiusOfRotation)
                .toString();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.handleEvent(new ConeEvent(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(new ConeEvent(this));
        }
    }
}
