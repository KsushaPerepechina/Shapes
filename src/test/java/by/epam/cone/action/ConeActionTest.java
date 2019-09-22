package by.epam.cone.action;

import by.epam.cone.action.impl.ConeActionImpl;
import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConeActionTest {
    private ConeAction coneAction;
    private Cone stretchedCone;
    private Cone compressedCone;
    private Cone cone;

    @BeforeClass
    public void setUp() throws ConeException {
        coneAction = new ConeActionImpl();
        stretchedCone = new Cone(new Point(0, 0, 8),
                new Point (0, 0, 0), 2);
        compressedCone = new Cone(new Point(7, 4, 4),
                new Point(7, 4, 3), 4);
        cone = new Cone(new Point(1, 1, 5),
                new Point(1, 1, 3), 1.5);
    }

    @DataProvider(name = "heightData")
    public Object[][] createHeightData() {
        return new Object[][]{{stretchedCone, 8}, {compressedCone, 1}, {cone, 2}};
    }

    @Test(dataProvider = "heightData")
    public void calculateHeightTest(Cone cone, double expected) {
        double actual = coneAction.calculateHeight(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "formingData")
    public Object[][] createFormingData() {
        return new Object[][]{{stretchedCone, 8.25}, {compressedCone, 4.12}, {cone, 2.5}};
    }

    @Test(dataProvider = "formingData")
    public void calculateFormingTest(Cone cone, double expected) {
        double actual = coneAction.calculateForming(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "baseCircleLengthData")
    public Object[][] createBaseCircleLengthData() {
        return new Object[][]{{stretchedCone, 12.57}, {compressedCone, 25.13}, {cone, 9.42}};
    }

    @Test(dataProvider = "baseCircleLengthData")
    public void calculateBaseCircleLengthTest(Cone cone, double expected) {
        double actual = coneAction.calculateBaseCircleLength(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "baseCircleAreaData")
    public Object[][] createConeData() {
        return new Object[][]{{stretchedCone, 12.57}, {compressedCone, 50.27}, {cone, 7.07}};
    }

    @Test(dataProvider = "baseCircleAreaData")
    public void calculateBaseCircleAreaTest(Cone cone, double expected) {
        double actual = coneAction.calculateBaseCircleArea(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "lateralSurfaceAreaData")
    public Object[][] createLateralSurfaceAreaData() {
        return new Object[][]{{stretchedCone, 103.62}, {compressedCone, 103.62}, {cone, 23.56}};
    }

    @Test(dataProvider = "lateralSurfaceAreaData")
    public void calculateLateralSurfaceAreaTest(Cone cone, double expected) {
        double actual = coneAction.calculateLateralSurfaceArea(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "fullSurfaceAreaData")
    public Object[][] createFullSurfaceAreaData() {
        return new Object[][]{{stretchedCone, 116.19}, {compressedCone, 153.89}, {cone, 30.63}};
    }

    @Test(dataProvider = "fullSurfaceAreaData")
    public void calculateFullSurfaceAreaTest(Cone cone, double expected) {
        double actual = coneAction.calculateFullSurfaceArea(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "volumeData")
    public Object[][] createVolumeData() {
        return new Object[][]{{stretchedCone, 33.51}, {compressedCone, 16.76}, {cone, 4.71}};
    }

    @Test(dataProvider = "volumeData")
    public void calculateVolumeTest(Cone cone, double expected) {
        double actual = coneAction.calculateVolume(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test
    public void isStraightCircularConeTest() {
        boolean actual = coneAction.isStraightCircularCone(compressedCone);
        Assert.assertTrue(actual);
    }

    @Test
    public void baseCircleBelongsToAnyCoordinatePlaneTest() {
        boolean actual = coneAction.baseCircleBelongsToAnyCoordinatePlane(stretchedCone);
        Assert.assertTrue(actual);
    }

    @Test
    public void baseCircleDoesNotBelongToAnyCoordinatePlaneTest() {
        boolean actual = coneAction.baseCircleBelongsToAnyCoordinatePlane(compressedCone);
        Assert.assertFalse(actual);
    }
}
