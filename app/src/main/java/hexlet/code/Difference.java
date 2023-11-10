package hexlet.code;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Difference {
    public static List<Map<String, Object>> filling(Map<String, Object> mapOne, Map<String, Object> mapTwo) {
        Set<String> keySet = new TreeSet<>(mapOne.keySet());
        keySet.addAll(mapTwo.keySet());
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (String key : keySet) {
            Object valueMapOne = checkForNull(mapOne.get(key));
            Object valueMapTwo = checkForNull(mapTwo.get(key));
            Map<String, Object> resultMap = new LinkedHashMap<>();
            if (!mapTwo.containsKey(key)) {
                resultMap.put("event", "removed");
                resultMap.put("key", key);
                resultMap.put("value", valueMapOne);
            } else if (!mapOne.containsKey(key)) {
                resultMap.put("event", "added");
                resultMap.put("key", key);
                resultMap.put("value", valueMapTwo);
            } else if (!valueMapOne.equals(valueMapTwo)) {
                resultMap.put("event", "updated");
                resultMap.put("key", key);
                resultMap.put("oldValue", valueMapOne);
                resultMap.put("newValue", valueMapTwo);
            } else {
                resultMap.put("event", "not changed");
                resultMap.put("key", key);
                resultMap.put("value", valueMapOne);
            }
            resultList.add(resultMap);
        }
        return resultList;
    }
    public static Object checkForNull(Object value) {
        if (value == null) {
            return "null";
        } else {
            return value;
        }
    }
}
