package hexlet.code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String nameOne, String nameTwo, String format) throws IOException {
        String dataOne = getData(nameOne);
        String dataTwo = getData(nameTwo);
        Map<String, Object> mapOne = Parser.parser(dataOne, nameOne);
        Map<String, Object> mapTwo = Parser.parser(dataTwo, nameTwo);
        return Formatter.choosingFormatter(Difference.filling(mapOne, mapTwo), format);
    }

    public static String generate(String fileOneName, String fileTwoName) throws IOException {
        return generate(fileOneName, fileTwoName, "stylish");
    }

    public static String getData(String fileName) throws IOException {
        Path path = Paths.get(fileName).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
