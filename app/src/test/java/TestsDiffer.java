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
        assertEquals(Differ.generate(getFixturePath("file1.json").toString(),
                        getFixturePath("fileEmpty.json").toString(), "stylish"),
                readFixture("stylishWithEmptyFile"));
    }
    @Test
    public void testStylishWithFilesJsonArray() throws Exception {
        assertEquals(Differ.generate(getFixturePath("fileWithArray1.json").toString(),
                        getFixturePath("fileWithArray2.json").toString(), "stylish"),
                readFixture("stylishWithFilesJsonArray"));
    }
    @Test
    public void testStylishWithFilesYmlArray() throws Exception {
        assertEquals(Differ.generate(getFixturePath("fileWithArray1.yml").toString(),
                        getFixturePath("fileWithArray2.yml").toString(), "stylish"),
                readFixture("stylishWithFilesJsonArray"));
    }
    @Test
    public void testPlainWithJsonFiles() throws Exception {
        assertEquals(Differ.generate(getFixturePath("file1.json").toString(),
                        getFixturePath("file3.json").toString(), "plain"),
                readFixture("plainWithJsonFiles"));
    }
    @Test
    public void testInpitJson() throws Exception {
        assertEquals(Differ.generate(getFixturePath("file1.json").toString(),
                        getFixturePath("file3.json").toString(), "json"),
                readFixture("inpitJson"));
    }
}
