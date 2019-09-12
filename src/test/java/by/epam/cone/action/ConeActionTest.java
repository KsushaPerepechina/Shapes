package by.epam.cone.action;

import by.epam.cone.action.impl.ConeActionImpl;
import org.testng.annotations.BeforeClass;

public class ConeActionTest {
    private ConeAction coneAction;

    @BeforeClass
    public void setUp() {
        coneAction = new ConeActionImpl();
    }
}
