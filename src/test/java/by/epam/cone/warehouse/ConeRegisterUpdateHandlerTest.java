package by.epam.cone.warehouse;

import by.epam.cone.action.ConeAction;
import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import by.epam.cone.observer.ConeEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeRegisterUpdateHandlerTest {
    private ConeAction coneAction;
    private ConeRegisterUpdateHandler handler;
    private ConeRegister register;
    private Cone cone;

    @BeforeClass
    public void setUp() throws ConeException {
        coneAction = new ConeActionImpl();
        handler = new ConeRegisterUpdateHandler();
        register = ConeRegister.getInstance();
        cone = new Cone(new Point(0, 0, 8),
                new Point (0, 0, 0), 2);
    }

    @Test
    public void handleEventTest() {
        double area = coneAction.calculateFullSurfaceArea(cone);
        double volume = coneAction.calculateVolume(cone);
        ConeRegisterEntry actual = new ConeRegisterEntry(area, volume);
        handler.handleEvent(new ConeEvent(cone));
        ConeRegisterEntry expected = register.selectRecord(cone);
        Assert.assertEquals(actual, expected);
    }
}
