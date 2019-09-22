package by.epam.cone.action;

import by.epam.cone.action.impl.TruncatedConeActionImpl;
import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TruncatedConeActionTest {

    private TruncatedConeAction truncatedConeAction;
    private Cone stretchedCone;
    private Cone compressedCone;
    private Cone cone;

    @BeforeClass
    public void setUp() throws ConeException {
        truncatedConeAction = new TruncatedConeActionImpl();
        stretchedCone = new Cone(new Point(0, 0, 8),
                new Point (0, 0, -1), 2);
        compressedCone = new Cone(new Point(7, 4, 1),
                new Point(7, 4, -1), 4);
        cone = new Cone(new Point(1, 1, 5),
                new Point(1, 1, -1), 1.5);
    }

    @DataProvider(name = "heightData")
    public Object[][] createHeightData() {
        return new Object[][]{{stretchedCone, 1}, {compressedCone, 1}, {cone, 1}};
    }

    @Test(dataProvider = "heightData")
    public void calculateHeightTest(Cone cone, double expected) {
        double actual = truncatedConeAction.calculateHeight(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "upperCircleRadiusData")
    public Object[][] createUpperCircleRadiusData() {
        return new Object[][]{{stretchedCone, 1.77}, {compressedCone, 2}, {cone, 1.25}};
    }

    @Test(dataProvider = "upperCircleRadiusData")
    public void calculateUpperCircleRadiusTest(Cone cone, double expected) {
        double actual = truncatedConeAction.calculateUpperCircleRadius(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @DataProvider(name = "volumeData")
    public Object[][] createVolumeData() {
        return new Object[][]{{stretchedCone, 11.22}, {compressedCone, 29.32}, {cone, 5.96}};
    }

    @Test(dataProvider = "volumeData")
    public void calculateVolumeTest(Cone cone, double expected) {
        double actual = truncatedConeAction.calculateVolume(cone);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
