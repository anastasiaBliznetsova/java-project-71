package hexlet.code;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Difference {
    public static List<Map<String, Object>> filling(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        Set<String> keySet = new TreeSet<>(mapOne.keySet());
        keySet.addAll(mapTwo.keySet());
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (String key : keySet) {
            Map<String, Object> resultMap = new LinkedHashMap<>();
            if (!mapTwo.containsKey(key)) {
                resultMap.put("event", "removed");
                resultMap.put("key", key);
                resultMap.put("value", mapOne.getOrDefault(key, "null"));
            } else if (!mapOne.containsKey(key)) {
                resultMap.put("event", "added");
                resultMap.put("key", key);
                resultMap.put("value", mapTwo.get(key));
            } else if (!isEquals(mapOne.getOrDefault(key, "null"),
                    mapTwo.getOrDefault(key, "null"))) {
                resultMap.put("event", "updated");
                resultMap.put("key", key);
                resultMap.put("oldValue", mapOne.getOrDefault(key, "null"));
                resultMap.put("newValue", mapTwo.getOrDefault(key, "null"));
            } else {
                resultMap.put("event", "not changed");
                resultMap.put("key", key);
                resultMap.put("value", mapOne.getOrDefault(key, "null"));
            }
            resultList.add(resultMap);
        }
        return resultList;
    }

    public static boolean isEquals(Object valueOne, Object valueTwo) {
        if (valueOne == null && valueTwo == null) {
            return true;
        } else if (valueOne == null || valueTwo == null) {
            return false;
        } else {
            return Objects.equals(valueOne, valueTwo);
        }
    }
}
