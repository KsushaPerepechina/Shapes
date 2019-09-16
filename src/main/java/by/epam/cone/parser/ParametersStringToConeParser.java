package by.epam.cone.parser;

import by.epam.cone.entity.Cone;
import by.epam.cone.entity.Point;
import by.epam.cone.exception.ConeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametersStringToConeParser {
    private static final String CONE_DATA_REGEX = "top\\s*\\(\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*\\)\\s*," +
            "\\s*base\\s+circle\\s+center\\s*\\(\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*;\\s*(-?\\d+\\.?\\d*)\\s*\\)\\s*," +
            "\\s*radius\\s+of\\s+rotation\\s+(\\d+.?\\d*)";

    public Cone parse(String stringOfParameters) throws ConeException {
        Pattern pattern = Pattern.compile(CONE_DATA_REGEX);
        Matcher matcher = pattern.matcher(stringOfParameters);
        if (!matcher.matches()) {
            throw new ConeException("Recipe position doesn't match the required pattern.");
        }
        Point top = new Point(Double.parseDouble(matcher.group(1)),
                Double.parseDouble(matcher.group(2)),
                Double.parseDouble(matcher.group(3)));
        Point baseCircleCenter = new Point(Double.parseDouble(matcher.group(4)),
                Double.parseDouble(matcher.group(5)),
                Double.parseDouble(matcher.group(6)));
        double radiusOfRotation = Double.parseDouble(matcher.group(7));
        //GenericFigureFactory genericFigureFactory = new createFigureFactory(FigureType.CONE);
        return new Cone(top, baseCircleCenter, radiusOfRotation);
    }
}
