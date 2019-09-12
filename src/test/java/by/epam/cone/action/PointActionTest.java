package by.epam.cone.action;

import by.epam.cone.action.impl.PointActionImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PointActionTest {
    private PointAction pointAction;

    @BeforeClass
    public void setUp() {
        pointAction = new PointActionImpl();
    }
}
