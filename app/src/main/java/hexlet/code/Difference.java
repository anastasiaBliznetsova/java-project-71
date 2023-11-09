package hexlet.code;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Difference {
    public static List<Map<String, Object>> filling(Map<Object, Object> mapOne, Map<Object, Object> mapTwo) {
        Set<Object> keySet = new TreeSet<>(mapOne.keySet());
        keySet.addAll(mapTwo.keySet());
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Object key : keySet) {
            Map<String, Object> resultMap = new LinkedHashMap<>();
            if (!mapTwo.containsKey(key)) {
                resultMap.put("event", "removed");
                resultMap.put("key", key);
                resultMap.put("value", mapOne.get(key));
            } else if (!mapOne.containsKey(key)) {
                resultMap.put("event", "added");
                resultMap.put("key", key);
                resultMap.put("value", mapTwo.get(key));
            } else if (!Objects.equals(mapOne.get(key), mapTwo.get(key))) {
                resultMap.put("event", "updated");
                resultMap.put("key", key);
                resultMap.put("oldValue", mapOne.get(key));
                resultMap.put("newValue", mapTwo.get(key));
            } else {
                resultMap.put("event", "not changed");
                resultMap.put("key", key);
                resultMap.put("value", mapOne.get(key));
            }
            resultList.add(resultMap);
        }
        return resultList;
    }
}