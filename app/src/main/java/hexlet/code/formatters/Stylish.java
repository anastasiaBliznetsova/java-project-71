package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String stylish(Map<Object, Object> map, Map<Object, Object> map2, Map<Object, Object> resultMap) {
        String result = "{\n";
        for (Object key: resultMap.keySet()) {
            if (resultMap.get(key) == null) {
                resultMap.put(key, "null");
            }
            if (map.containsKey(key)) {
                if (map.get(key) == null) {
                    map.put(key, "null");
                }
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
