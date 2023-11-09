package hexlet.code.formatters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(List<Map<String, Object>> list) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> map: list) {
            switch (map.get("event").toString()) {
                case "removed":
                    result.append("Property '").append(map.get("key")).append("' was removed").append("\r\n");
                    break;
                case "added":
                    result.append("Property '")
                            .append(map.get("key")).append("' was added with value: ")
                            .append(replaceWithComplexValue(map.get("value"))).append("\r\n");
                    break;
                case "updated":
                    result.append("Property '")
                            .append(map.get("key")).append("' was updated. From ")
                            .append(replaceWithComplexValue(map.get("oldValue"))).append(" to ")
                            .append(replaceWithComplexValue(map.get("newValue"))).append("\r\n");
                    break;
                default:
                    break;
            }
        }
        return result.toString().trim();
    }

    public static String replaceWithComplexValue(Object value) {
        if (value instanceof Collection<?> || value instanceof Arrays || value instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (value.equals("null")) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
