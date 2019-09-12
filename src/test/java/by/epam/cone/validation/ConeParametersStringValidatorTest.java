package by.epam.cone.validation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConeParametersStringValidatorTest {
    private ConeParametersStringValidator coneParametersStringValidator;
    private String coneData;

    @BeforeClass
    public void setUp() {
        coneParametersStringValidator = new ConeParametersStringValidator();
        coneData = "top (0;0;0), base circle center (0;0;-5.5), radius of rotation 4";
    }

    @Test
    public void correctPositionTest() {
        Assert.assertTrue(coneParametersStringValidator.isCorrect(coneData));
    }

    @Test
    public void incorrectPositionTest() {
        Assert.assertFalse(coneParametersStringValidator.isCorrect(coneData + ", height 5.5"));
    }
}