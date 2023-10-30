package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Stylish;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String file, String file2, String format) throws IOException {
        String fileData1 = getData(file);
        String fileData2 = getData(file2);
        ObjectMapper objectMapper = Parser.parser(file);
        Map<Object, Object> map = objectMapper.readValue(fileData1, new TypeReference<>() { });
        Map<Object, Object> map2 = objectMapper.readValue(fileData2, new TypeReference<>() { });
        Map<Object, Object> resultMap = new TreeMap<>();
        resultMap.putAll(map);
        resultMap.putAll(map2);
        return Stylish.stylish(map, map2, resultMap);
    }
    public static String getData(String nameFile) throws IOException {
        Path path = Paths.get("src/main/java/hexlet/code/files/" + nameFile).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
