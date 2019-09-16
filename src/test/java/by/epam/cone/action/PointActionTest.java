package by.epam.cone.action;

import by.epam.cone.action.impl.PointActionImpl;
import by.epam.cone.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PointActionTest {
    private PointAction pointAction;
    private Point a;
    private Point b;

    @BeforeClass
    public void setUp() {
        pointAction = new PointActionImpl();
        a = new Point(3, 11, -6);
        b = new Point(0.5, -7, 0);
    }

    @Test
    public void calculateSegmentLengthTest() {
        double actual = pointAction.calculateSegmentLength(a, b);
        Assert.assertEquals(actual, 19.14, 0.01);
    }
}
