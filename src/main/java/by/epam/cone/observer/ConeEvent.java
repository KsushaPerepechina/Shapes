package by.epam.cone.observer;

import by.epam.cone.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {

    public ConeEvent(Object source) {
        super(source);
    }

    public Cone getCone(){
        return (Cone)getSource();
    }
}
