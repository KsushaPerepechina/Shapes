package by.epam.cone.exception;

import java.io.IOException;

public class InaccessibleFileException extends IOException {
    public InaccessibleFileException() {
    }

    public InaccessibleFileException(String message) {
        super(message);
    }

    public InaccessibleFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public InaccessibleFileException(Throwable cause) {
        super(cause);
    }
}
