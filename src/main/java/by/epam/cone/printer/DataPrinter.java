package by.epam.cone.printer;

import by.epam.cone.exception.InaccessibleFileException;
import by.epam.cone.validation.TxtFilePathValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DataPrinter {
    private static final Logger log = LogManager.getLogger(DataPrinter.class);

    public void writeString(final String filePath, final String outputLine) throws InaccessibleFileException {
        TxtFilePathValidator txtFilePathValidator = new TxtFilePathValidator();
        if(!txtFilePathValidator.isCorrect(filePath)) {
            throw new InaccessibleFileException("File path <" + filePath + "> is incorrect.");
        }
        if(Files.notExists(Paths.get(filePath))) {
            throw new InaccessibleFileException("File <" + filePath + "> does not exist.");
        }
        if(!Files.isWritable(Paths.get(filePath))) {
            throw new InaccessibleFileException("Writing to file <" + filePath + "> is not allowed.");
        }
        try {
            Files.write(Paths.get(filePath), outputLine.getBytes(), StandardOpenOption.APPEND);
        } catch(IOException e) {
            log.error(e.getMessage());
        }
    }
}
