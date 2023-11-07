package hexlet.code.formatters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(List<Map<Object, Object>> list) {
        StringBuilder result = new StringBuilder();
        for (Map<Object, Object> map: list) {
            switch (map.get("event").toString()) {
                case "removed":
                    result.append("Property '").append(map.get("key")).append("' was removed").append("\n");
                    break;
                case "added":
                    if (map.get("value") instanceof Collection<?> || map.get("value") instanceof Arrays
                            || map.get("value") instanceof Map<?, ?>) {
                        map.put("value", "[complex value]");
                    }
                    result.append("Property '")
                            .append(map.get("key"))
                            .append("' was added with value: ")
                            .append(map.get("value"))
                            .append("\n");
                    break;
                case "updated":
                    if (!(map.get("oldValue") instanceof String) && !(map.get("oldValue") instanceof Integer)) {
                        map.put("oldValue", "[complex value]");
                    }
                    if (!(map.get("newValue") instanceof String)) {
                        map.put("newValue", "[complex value]");
                    }
                    result.append("Property '")
                            .append(map.get("key"))
                            .append("' was updated. From ")
                            .append(map.get("oldValue"))
                            .append(" to ")
                            .append(map.get("newValue"))
                            .append("\n");
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }
}
