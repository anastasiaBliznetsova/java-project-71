import hexlet.code.Differ;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsDiffer {
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
        assertEquals(Differ.generate(readFixture("file1.json"),
                readFixture("fileEmpty.json"), "stylish"),
                readFixture("stylishWithEmptyFile"));
    }

    @Test
    public void testStylishWithFilesJsonArray() throws Exception {
        assertEquals(Differ.generate(readFixture("fileWithArray1.json"),
                readFixture("fileWithArray2.json"), "stylish"),
                readFixture("stylishWithFilesJsonArray"));
    }
    @Test
    public void testStylishWithFilesYmlArray() throws Exception {
        assertEquals(Differ.generate(readFixture("fileWithArray1.yml"),
                readFixture("fileWithArray2.yml"), "stylish"),
                readFixture("stylishWithFilesJsonArray"));
    }
    @Test
    public void testPlainWithJsonFiles() throws Exception {
        assertEquals(Differ.generate(readFixture("file1.json"), readFixture("file3.json"), "plain"),
                readFixture("plainWithJsonFiles"));
    }
    @Test
    public void testInpitJson() throws Exception {
        assertEquals(Differ.generate(readFixture("file1.json"), readFixture("file3.json"), "json"),
                readFixture("inpitJson"));
    }
}
