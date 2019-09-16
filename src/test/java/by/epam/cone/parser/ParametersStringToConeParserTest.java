package by.epam.cone.parser;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParametersStringToConeParserTest {
    private ParametersStringToConeParser parametersStringToConeParser;
    private String coneData;
    private Cone cone;

    @BeforeClass
    public void setUp() {
        parametersStringToConeParser = new ParametersStringToConeParser();
        coneData = "top (0;0;0), base circle center (0;0;-5.5), radius of rotation 4";
        cone = new Cone(new Point(0, 0, 0), new Point(0,0,-5.5), 4);
    }

    @Test
    public void parseTest() throws ConeException {
        Assert.assertEquals(parametersStringToConeParser.parse(coneData), cone);//TODO !methods in assert
    }

    @Test(expectedExceptions = ConeException.class)
    public void parseUnmatchedPositionTest() throws ConeException {
        parametersStringToConeParser.parse(coneData + ", height 5.5");
    }
}