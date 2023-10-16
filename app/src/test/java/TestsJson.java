import hexlet.code.Differ;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class TestsJson {
    @Test
    public void testDifferOne() {
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String result = "{\n"
                + "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n"
                + "}";
        File file1 = new File(path1);
        File file2 = new File(path2);
        try {
            assertEquals(Differ.generate(file1, file2), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testDifferTwo() {
        String path1 = "src/test/resources/file1.json";
        String pathEmpty = "src/test/resources/fileEmpty.json";
        String result = "{\n"
                + "- follow: false\n"
                + "- host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "}";
        File file1 = new File(path1);
        File fileE = new File(pathEmpty);
        try {
            assertEquals(Differ.generate(file1, fileE), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testDifferThree() {
        String path1 = "src/test/resources/file1.json";
        String pathEmpty = "src/test/resources/fileEmpty.json";
        String result = "{\n"
                + "+ follow: false\n"
                + "+ host: hexlet.io\n"
                + "+ proxy: 123.234.53.22\n"
                + "+ timeout: 50\n"
                + "}";
        File file1 = new File(path1);
        File fileE = new File(pathEmpty);
        try {
            assertEquals(Differ.generate(fileE, file1), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
}
