package by.epam.cone.repository;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import by.epam.cone.specification.Specification;
import by.epam.cone.specification.IdSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeRepositoryTest {
    private ConeRepository repository;
    private Cone stretchedCone;
    private Cone compressedCone;
    private Cone cone;

    @BeforeClass
    public void setUp() throws ConeException {
        repository = new ConeRepository();
        stretchedCone = new Cone(new Point(0, 0, 8),
                new Point (0, 0, 0), 2);
        compressedCone = new Cone(new Point(7, 4, 4),
                new Point(7, 4, 3), 4);
        cone = new Cone(new Point(1, 1, 5),
                new Point(1, 1, 3), 1.5);
    }

    @Test
    public void addTest() {
        repository.add(cone);
        Specification idSpecification = new IdSpecification(cone.getId());
        boolean actual = repository.findBy(idSpecification).contains(cone);
        Assert.assertTrue(actual);
        repository.remove(cone);
    }

    @Test
    public void removeTest() {
        repository.add(cone);
        repository.remove(cone);
        Specification idSpecification = new IdSpecification(cone.getId());
        boolean actual = repository.findBy(idSpecification).contains(cone);
        Assert.assertFalse(actual);
    }

    @Test
    public void updateTest() throws ConeException {
        repository.add(cone);
        cone.setRadiusOfRotation(4);
        Specification idSpecification = new IdSpecification(cone.getId());
        Cone actual = repository.findBy(idSpecification).get(0);
        Assert.assertEquals(actual, cone);
    }
}
