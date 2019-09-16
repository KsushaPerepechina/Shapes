package by.epam.cone.reader;


import by.epam.cone.exception.InaccessibleFileException;
import by.epam.cone.validation.TxtFilePathValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {
    private static final Logger log = LogManager.getLogger(DataReader.class);

    public List<String> readAllLines(final String filePath) throws InaccessibleFileException {
        List<String> fileContent = null;
        TxtFilePathValidator txtFilePathValidator = new TxtFilePathValidator();
        if(!txtFilePathValidator.isCorrect(filePath)) {
            throw new InaccessibleFileException("File path <" + filePath + "> is incorrect.");
        }
        if(Files.notExists(Paths.get(filePath))) {
            throw new InaccessibleFileException("File <" + filePath + "> does not exist.");
        }
        if(!Files.isReadable(Paths.get(filePath))) {
            throw new InaccessibleFileException("Reading of file <" + filePath + "> is not allowed.");
        }
        try {
            fileContent = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return fileContent;
    }
}
