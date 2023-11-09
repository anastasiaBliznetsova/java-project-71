import hexlet.code.Differ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsDiffer {
    static final String PATH = "src/test/resources/";
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @Test
    public void testStylishWithEmptyFile() throws Exception {
        assertEquals(Differ.generate(PATH + "file1.json",
                        PATH + "fileEmpty.json", "stylish"),
                readFixture("StylishWithEmptyFile"));
    }

    @Test
    public void testStylishWithFilesJsonArray() throws Exception {
        assertEquals(Differ.generate(PATH + "fileWithArray1.json",
                        PATH + "fileWithArray2.json", "stylish"),
                readFixture("StylishWithFilesJsonArray"));
    }
    @Test
    public void testStylishWithFilesYmlArray() throws Exception {
        assertEquals(Differ.generate(PATH + "fileWithArray1.yml",
                        PATH + "fileWithArray2.yml", "stylish"),
                readFixture("StylishWithFilesJsonArray"));
    }
    @Test
    public void testPlainWithJsonFiles() throws Exception {
        assertEquals(Differ.generate(PATH + "file1.json", PATH + "file3.json", "plain"),
                readFixture("PlainWithJsonFiles"));
    }
    @Test
    public void testInpitJson() throws Exception {
        assertEquals(Differ.generate(PATH + "file1.json", PATH + "file3.json", "json"),
                readFixture("InpitJson"));
    }
}
