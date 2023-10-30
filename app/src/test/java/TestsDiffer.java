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
            assertEquals(Differ.generate("file1.json", "file2.json", ""), result);
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
            assertEquals(Differ.generate("file1.json", "fileEmpty.json", ""), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testDifferThree() {
        String result = "{\n"
                + "+ follow: false\n"
                + "+ host: hexlet.io\n"
                + "+ proxy: 123.234.53.22\n"
                + "+ timeout: 50\n"
                + "}";
        try {
            assertEquals(Differ.generate("fileEmpty.json", "file1.json", ""), result);
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
            assertEquals(Differ.generate("file1.yml", "file2.yml", ""), result);
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
            assertEquals(Differ.generate("file1.yml", "fileEmpty.yml", ""), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
    @Test
    public void testDifferSix() {
        String result = "{\n"
                + "  chars1: [a, b, c]\n"
                + "- chars2: [d, e, f]\n"
                + "+ chars2: false\n"
                + "- checked: false\n"
                + "+ checked: true\n"
                + "- default: null\n"
                + "+ default: [value1, value2]\n"
                + "- id: 45\n"
                + "+ id: null\n"
                + "- key1: value1\n"
                + "+ key2: value2\n"
                + "  numbers1: [1, 2, 3, 4]\n"
                + "- numbers2: [2, 3, 4, 5]\n"
                + "+ numbers2: [22, 33, 44, 55]\n"
                + "- numbers3: [3, 4, 5]\n"
                + "+ numbers4: [4, 5, 6]\n"
                + "+ obj1: {nestedKey=value, isNested=true}\n"
                + "- setting1: Some value\n"
                + "+ setting1: Another value\n"
                + "- setting2: 200\n"
                + "+ setting2: 300\n"
                + "- setting3: true\n"
                + "+ setting3: none\n"
                + "}";
        try {
            assertEquals(Differ.generate("fileWithArray1.json", "fileWithArray2.json", ""), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testDifferSeven() {
        String result = "{\n"
                + "  chars1: [a, b, c]\n"
                + "- chars2: [d, e, f]\n"
                + "+ chars2: false\n"
                + "- checked: false\n"
                + "+ checked: true\n"
                + "- default: null\n"
                + "+ default: [value1, value2]\n"
                + "- id: 45\n"
                + "+ id: null\n"
                + "- key1: value1\n"
                + "+ key2: value2\n"
                + "  numbers1: [1, 2, 3, 4]\n"
                + "- numbers2: [2, 3, 4, 5]\n"
                + "+ numbers2: [22, 33, 44, 55]\n"
                + "- numbers3: [3, 4, 5]\n"
                + "+ numbers4: [4, 5, 6]\n"
                + "+ obj1: {nestedKey=value, isNested=true}\n"
                + "- setting1: Some value\n"
                + "+ setting1: Another value\n"
                + "- setting2: 200\n"
                + "+ setting2: 300\n"
                + "- setting3: true\n"
                + "+ setting3: none\n"
                + "}";
        try {
            assertEquals(Differ.generate("fileWithArray1.yml", "fileWithArray2.yml", ""), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
}
