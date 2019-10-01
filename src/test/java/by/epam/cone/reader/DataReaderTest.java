package by.epam.cone.reader;

import by.epam.cone.exception.InaccessibleFileException;
import by.epam.cone.printer.DataPrinter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private DataReader dataReader;
    private DataPrinter dataPrinter;
    private static final String STRING_FILE_PATH = "data/test_file.txt";
    private Path FILE_PATH = Paths.get(STRING_FILE_PATH);
    private List<String> inputLines;

    @BeforeClass
    public void setUp() throws IOException {
        dataReader = new DataReader();
        dataPrinter = new DataPrinter();
        Files.createFile(FILE_PATH);
        inputLines = new ArrayList<>(
                Arrays.asList("volume 15.4", "base circle area 3.8"));
    }

    @AfterClass
    public void deleteTestFile() throws IOException {
        Files.deleteIfExists(FILE_PATH);
    }

    @Test
    public void readAllLinesTest() throws InaccessibleFileException {
        inputLines.forEach(line -> {
            try {
                dataPrinter.writeString(STRING_FILE_PATH, line + "\n");
            } catch (InaccessibleFileException e) {
                e.printStackTrace();
            }
        });
        Assert.assertEquals(dataReader.readAllLines(STRING_FILE_PATH), inputLines);
    }
}