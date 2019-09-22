package by.epam.cone.validation;

public class ConeParametersStringValidator {

    //example for RegEx: "top (0;0;8.5), base circle center (0;0;0), radius of rotation 2"
    private static final String CORRECT_STRING_REGEX = "top\\s*\\(\\s*-?\\d+\\.?\\d*\\s*;\\s*-?\\d+\\.?\\d*\\s*;\\s*-?\\d+\\.?\\d*\\s*\\)\\s*," +
            "\\s*base\\s+circle\\s+center\\s*\\(\\s*-?\\d+\\.?\\d*\\s*;\\s*-?\\d+\\.?\\d*\\s*;\\s*-?\\d+\\.?\\d*\\s*\\)\\s*," +
            "\\s*radius\\s+of\\s+rotation\\s+\\d+.?\\d*";

    public boolean isCorrect(String inputString) {
        return inputString.matches(CORRECT_STRING_REGEX);
    }
}
