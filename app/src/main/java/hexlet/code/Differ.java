package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Differ {
    public static String generate(String fileOneName, String fileTwoName, String format) throws IOException {
        String fileOneData = getData(fileOneName);
        String fileTwoData = getData(fileTwoName);
        ObjectMapper objectMapper = Parser.parser(fileOneName);
        Map<Object, Object> mapFileOne = objectMapper.readValue(fileOneData, new TypeReference<>() { });
        Map<Object, Object> mapFileTwo = objectMapper.readValue(fileTwoData, new TypeReference<>() { });
        return Formatter.choosingFormatter(filling(mapFileOne, mapFileTwo), format);
    }

    public static String generate(String fileOneName, String fileTwoName) throws IOException {
        return generate(fileOneName, fileTwoName, "stylish");
    }

    public static List<Map<Object, Object>> filling(Map<Object, Object> mapFileOne, Map<Object, Object> mapFileTwo) {
        Map<Object, Object> overallTreeMap = new TreeMap<>();
        overallTreeMap.putAll(mapFileOne);
        overallTreeMap.putAll(mapFileTwo);
        List<Map<Object, Object>> resultList = new ArrayList<>();
        for (Object key : overallTreeMap.keySet()) {
            Map<Object, Object> resultMap = new LinkedHashMap<>();
            overallTreeMap.putIfAbsent(key, "null");
            if (mapFileOne.containsKey(key)) {
                if (!mapFileTwo.containsKey(key)) {
                    resultMap.put("event", "removed");
                    resultMap.put("key", key);
                    resultMap.put("value", overallTreeMap.get(key));
                } else if (overallTreeMap.get(key).equals(mapFileOne.get(key))) {
                    resultMap.put("event", "not changed");
                    resultMap.put("key", key);
                    resultMap.put("value", overallTreeMap.get(key));
                } else {
                    resultMap.put("event", "updated");
                    resultMap.put("key", key);
                    resultMap.put("oldValue", mapFileOne.get(key));
                    resultMap.put("newValue", overallTreeMap.get(key));
                }
            } else if (mapFileTwo.containsKey(key)) {
                resultMap.put("event", "added");
                resultMap.put("key", key);
                resultMap.put("value", overallTreeMap.get(key));
            }
            resultList.add(resultMap);
        }
        return resultList;
    }

    public static String getData(String nameFile) throws IOException {
        Path path = Paths.get(nameFile).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
