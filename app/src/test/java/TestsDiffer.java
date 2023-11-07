import hexlet.code.Differ;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestsDiffer {
    static final String PATH = "src/test/resources/";
    @Test
    public void testStylishWishJsonFiles() throws IOException {
        String result = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertEquals(Differ.generate(PATH + "file1.json", PATH + "file2.json", "stylish"), result);
    }
    @Test
    public void testStylishWithEmptyFile() throws IOException {
        String result = "{\n"
                + "  - follow: false\n"
                + "  - host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "}";
        assertEquals(Differ.generate(PATH + "file1.json",  PATH + "fileEmpty.json", "stylish"), result);
    }
    @Test
    public void testStylishWishYmlFiles() {
        String result = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        try {
            assertEquals(Differ.generate(PATH + "file1.yml", PATH + "file2.yml", "stylish"), result);
        } catch (IOException thrown) {
            assertNotEquals("", thrown.getMessage());
        }
    }
    @Test
    public void testStylishWithFilesJsonArray() throws IOException {
        String result = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(Differ.generate(PATH + "fileWithArray1.json", PATH + "fileWithArray2.json", "stylish"), result);
    }
    @Test
    public void testStylishWithFilesYmlArray() throws IOException {
        String result = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(Differ.generate(PATH + "fileWithArray1.yml", PATH + "fileWithArray2.yml", "stylish"), result);
    }
    @Test
    public void testPlainWithJsonFiles() throws IOException {
        String result = "Property 'follow' was removed\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to [complex value]\n"
                + "Property 'verbose' was added with value: true\n";
        assertEquals(Differ.generate(PATH + "file1.json", PATH + "file3.json", "plain"), result);
    }
    @Test
    public void testPlainWishYmlFiles() throws IOException {
        String result = "Property 'follow' was removed\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to [complex value]\n"
                + "Property 'verbose' was added with value: true\n";
        assertEquals(Differ.generate(PATH + "file1.yml", PATH + "file3.yml", "plain"), result);
    }
    @Test
    public void testDifferNine() throws IOException {
        String result = "[{\"event\":\"removed\",\"key\":\"follow\",\"value\":false},"
                + "{\"event\":\"not changed\",\"key\":\"host\",\"value\":\"hexlet.io\"},"
                + "{\"event\":\"added\",\"key\":\"obj1\",\"value\":{\"nestedKey\":\"value\",\"isNested\":true}},"
                + "{\"event\":\"removed\",\"key\":\"proxy\",\"value\":\"123.234.53.22\"},"
                + "{\"event\":\"updated\",\"key\":\"timeout\",\"oldValue\":50,\"newValue\":[1,2,3,4]},"
                + "{\"event\":\"added\",\"key\":\"verbose\",\"value\":true}]";

        assertEquals(Differ.generate(PATH + "file1.json", PATH + "file3.json", "json"), result);
    }
    @Test
    public void testJsonWithJsonEmptyFile() throws IOException {
        String result = "[{\"event\":\"removed\",\"key\":\"follow\",\"value\":false},"
                + "{\"event\":\"removed\",\"key\":\"host\",\"value\":\"hexlet.io\"},"
                + "{\"event\":\"removed\",\"key\":\"proxy\",\"value\":\"123.234.53.22\"},"
                + "{\"event\":\"removed\",\"key\":\"timeout\",\"value\":50}]";
        assertEquals(Differ.generate(PATH + "file1.json", PATH + "fileEmpty.json", "json"), result);
    }

}
