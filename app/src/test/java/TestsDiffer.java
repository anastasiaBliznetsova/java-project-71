import hexlet.code.Differ;
//import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class TestsDiffer {
    @Test
    public void testDifferOne() {
        String result = "{\n"
                + "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n"
                + "}";
        try {
            assertEquals(Differ.generate("file1.json", "file2.json"), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testDifferTwo() {
        String result = "{\n"
                + "- follow: false\n"
                + "- host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "}";
        try {
            assertEquals(Differ.generate("file1.json", "fileEmpty.json"), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testDifferThree() {
//        String path1 = "src/test/resources/file1.json";
//        String pathEmpty = "src/test/resources/fileEmpty.json";
        String result = "{\n"
                + "+ follow: false\n"
                + "+ host: hexlet.io\n"
                + "+ proxy: 123.234.53.22\n"
                + "+ timeout: 50\n"
                + "}";
//        File file1 = new File(path1);
//        File fileE = new File(pathEmpty);
        try {
            assertEquals(Differ.generate("fileEmpty.json", "file1.json"), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
    @Test
    public void testDifferFour() {
        String result = "{\n"
                + "- follow: false\n"
                + "  host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n"
                + "}";
        try {
            assertEquals(Differ.generate("file1.yml", "file2.yml"), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
    @Test
    public void testDifferFive() {
        String result = "{\n"
                + "- follow: false\n"
                + "- host: hexlet.io\n"
                + "- proxy: 123.234.53.22\n"
                + "- timeout: 50\n"
                + "}";
        try {
            assertEquals(Differ.generate("file1.yml", "fileEmpty.yml"), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
}
