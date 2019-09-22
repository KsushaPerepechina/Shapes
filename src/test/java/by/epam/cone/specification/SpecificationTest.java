package by.epam.cone.specification;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpecificationTest {
    private Cone cone;

    @BeforeClass
    public void setUp() throws ConeException {
        cone = new Cone(new Point(1, 1, 5),
                new Point(1, 1, 3), 1.5);
    }

    @Test
    public void searchByIdPositiveTest() {
        Specification idSpecification = new IdSpecification(cone.getId());
        boolean actual = idSpecification.specified(cone);
        Assert.assertTrue(actual);
    }

    @Test
    public void searchByIdNegativeTest() {
        Specification idSpecification = new IdSpecification(cone.getId() + 1);
        boolean actual = idSpecification.specified(cone);
        Assert.assertFalse(actual);
    }

    @Test
    public void searchByRangeOfAreaPositiveTest() {
        Specification areaSpecification = new AreaRangeSpecification(15, 45);
        boolean actual = areaSpecification.specified(cone);
        Assert.assertTrue(actual);
    }

    @Test
    public void searchByRangeOfAreaNegativeTest() {
        Specification areaSpecification = new AreaRangeSpecification(0, 10);
        boolean actual = areaSpecification.specified(cone);
        Assert.assertFalse(actual);
    }

    @Test
    public void searchByRangeOfVolumePositiveTest() {
        Specification volumeSpecification = new VolumeRangeSpecification(0, 5);
        boolean actual = volumeSpecification.specified(cone);
        Assert.assertTrue(actual);
    }

    @Test
    public void searchByRangeOfVolumeNegativeTest() {
        Specification volumeSpecification = new VolumeRangeSpecification(5, 10);
        boolean actual = volumeSpecification.specified(cone);
        Assert.assertFalse(actual);
    }

    @Test
    public void searchByGreaterVolumePositiveTest() {
        Specification areaLowerBoundSpecification = new VolumeLowerBoundSpecification(1);
        boolean actual = areaLowerBoundSpecification.specified(cone);
        Assert.assertTrue(actual);
    }

    @Test
    public void searchByGreaterVolumeNegativeTest() {
        Specification areaLowerBoundSpecification = new VolumeLowerBoundSpecification(10);
        boolean actual = areaLowerBoundSpecification.specified(cone);
        Assert.assertFalse(actual);
    }
}
