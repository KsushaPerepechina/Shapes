package by.epam.cone.parser;

import by.epam.cone.creator.ConeFactory;
import by.epam.cone.creator.GenericFigureFactory;
import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametersStringToConeParser {

    private static final String CONE_DATA_REGEX = "top\\s*\\(\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*\\)\\s*,"
            + "\\s*base\\s+circle\\s+center\\s*\\(\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*\\)\\s*,"
            + "\\s*radius\\s+of\\s+rotation\\s+(\\d+.?\\d*)";

    public Cone parse(String stringOfParameters) throws ConeException {
        Pattern pattern = Pattern.compile(CONE_DATA_REGEX);
        Matcher matcher = pattern.matcher(stringOfParameters);
        if (!matcher.matches()) {
            throw new ConeException("Unable to create cone: string \"" + stringOfParameters +
                    "\" doesn't match the required pattern.");
        }
        GenericFigureFactory coneFactory = new ConeFactory();
        Cone cone = (Cone)coneFactory.create();
        cone.setTop(new Point(Double.parseDouble(matcher.group(1)),
                Double.parseDouble(matcher.group(2)),
                Double.parseDouble(matcher.group(3))));
        cone.setBaseCircleCenter(new Point(Double.parseDouble(matcher.group(4)),
                Double.parseDouble(matcher.group(5)),
                Double.parseDouble(matcher.group(6))));
        cone.setRadiusOfRotation(Double.parseDouble(matcher.group(7)));
        return cone;
    }
}
