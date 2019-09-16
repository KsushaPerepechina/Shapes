package by.epam.cone.warehouse;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

import java.util.HashMap;
import java.util.Map;

public class ConeRegister {
    private static ConeRegister register;
    private ConeAction coneAction = new ConeActionImpl();
    private static Map<Long, Double> areas = new HashMap<>();
    private static Map<Long, Double> volumes = new HashMap<>();

    public static ConeRegister getInstance() {
        if (register == null) {
            register = new ConeRegister();
        }
        return register;
    }

    public void addRecord(Cone cone) {
        areas.put(cone.getId(), coneAction.calculateFullSurfaceArea(cone));
        volumes.put(cone.getId(), coneAction.calculateVolume(cone));
    }

    public void removeRecord(Cone cone) {
        areas.remove(cone.getId());
        volumes.remove(cone.getId());
    }
}//TODO