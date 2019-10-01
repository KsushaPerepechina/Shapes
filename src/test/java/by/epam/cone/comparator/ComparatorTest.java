package by.epam.cone.comparator;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;

public class ComparatorTest {
    private Cone stretchedCone;
    private Cone compressedCone;

    private static final int LARGER = 1;
    private static final int LESS = -1;

    @BeforeClass
    public void setUp() throws ConeException {
        stretchedCone = new Cone(new Point(0, 0, 8),
                new Point (0, 0, 0), 2);
        compressedCone = new Cone(new Point(7, 4, 4),
                new Point(7, 4, 3), 4);
    }

    @Test
    public void sortByIdPositiveTest() {
        Comparator idComparator = new IdComparator();
        int result = idComparator.compare(stretchedCone, compressedCone);
        Assert.assertEquals(result, LESS);
    }

    @Test
    public void sortByRadiusPositiveTest() {
        Comparator radiusComparator = new RadiusComparator();
        int result = radiusComparator.compare(stretchedCone, compressedCone);
        Assert.assertEquals(result, LESS);
    }

    @Test
    public void sortByVolumePositiveTest() {
        Comparator volumeComparator = new VolumeComparator();
        int result = volumeComparator.compare(stretchedCone, compressedCone);
        Assert.assertEquals(result, LARGER);
    }

    @Test
    public void sortByIdNegativeTest() {
        Comparator idComparator = new IdComparator();
        int result = idComparator.compare(compressedCone, stretchedCone);
        Assert.assertNotEquals(result, LESS);
    }

    @Test
    public void sortByRadiusNegativeTest() {
        Comparator radiusComparator = new RadiusComparator();
        int result = radiusComparator.compare(compressedCone, stretchedCone);
        Assert.assertNotEquals(result, LESS);
    }

    @Test
    public void sortByVolumeNegativeTest() {
        Comparator volumeComparator = new VolumeComparator();
        int result = volumeComparator.compare(compressedCone, stretchedCone);
        Assert.assertNotEquals(result, LARGER);
    }
}
