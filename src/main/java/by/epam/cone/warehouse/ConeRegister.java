package by.epam.cone.warehouse;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;

import java.util.HashMap;
import java.util.Map;

public class ConeRegister {
    private static ConeRegister register;
    private ConeAction coneAction = new ConeActionImpl();
    private Map<Long, ConeRegisterEntry> entries = new HashMap<>();

    public static ConeRegister getInstance() {
        if (register == null) {
            register = new ConeRegister();
        }
        return register;
    }

    public void addRecord(Cone cone) {
        long id = cone.getId();
        double area = coneAction.calculateFullSurfaceArea(cone);
        double volume = coneAction.calculateVolume(cone);
        entries.put(id, new ConeRegisterEntry(area, volume));
    }

    public ConeRegisterEntry selectRecord(Cone cone) {
        return entries.get(cone.getId());
    }
}