package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String file, String file2) throws IOException {
        Path path = Paths.get("src/main/java/hexlet/code/files/" + file).toAbsolutePath().normalize();
        String fileData1 = Files.readString(path);
        Path path2 = Paths.get("src/main/java/hexlet/code/files/" + file2).toAbsolutePath().normalize();
        String fileData2 = Files.readString(path2);
        ObjectMapper objectMapper = Parser.parser(file);
        Map<Object, Object> map = objectMapper.readValue(fileData1, new TypeReference<>() { });
        Map<Object, Object> map2 = objectMapper.readValue(fileData2, new TypeReference<>() { });
        Map<Object, Object> resultMap = new TreeMap<>();
        resultMap.putAll(map);
        resultMap.putAll(map2);
        String result = "{\n";
        for (Object key: resultMap.keySet()) {
            if (map.containsKey(key)) {
                if (!map2.containsKey(key)) {
                    result += "- " + key + ": " + resultMap.get(key) + "\n";
                } else if (resultMap.get(key).equals(map.get(key))) {
                    result += "  " + key + ": " + resultMap.get(key) + "\n";
                } else {
                    result += "- " + key + ": " + map.get(key) + "\n";
                    result += "+ " + key + ": " + resultMap.get(key) + "\n";
                }
            } else if (map2.containsKey(key)) {
                result += "+ " + key + ": " + resultMap.get(key) + "\n";
            } else {
                result += "- " + key + ": " + resultMap.get(key) + "\n";
            }
        }
        result += "}";
        return result;
    }
}
