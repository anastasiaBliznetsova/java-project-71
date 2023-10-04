package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(Map<String, Object> map, Map<String, Object> map2){
        Map<String, Object> resultMap = new TreeMap<>();
        resultMap.putAll(map);
        resultMap.putAll(map2);
        String result = "{\n";
        for (String key: resultMap.keySet()) {
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
