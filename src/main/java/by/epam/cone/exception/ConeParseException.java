package by.epam.cone.exception;

public class ConeParseException extends Exception {
    public ConeParseException() {
    }

    public ConeParseException(String message) {
        super(message);
    }

    public ConeParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConeParseException(Throwable cause) {
        super(cause);
    }
}
