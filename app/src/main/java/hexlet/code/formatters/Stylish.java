package hexlet.code.formatters;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<Object, Object>> list) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<Object, Object> map: list) {
            switch (map.get("event").toString()) {
                case "removed":
                    result.append("  - ").append(map.get("key")).append(": ").append(map.get("value")).append("\n");
                    break;
                case "not changed":
                    result.append("    ").append(map.get("key")).append(": ").append(map.get("value")).append("\n");
                    break;
                case "added":
                    result.append("  + ").append(map.get("key")).append(": ").append(map.get("value")).append("\n");
                    break;
                case "updated":
                    result.append("  - ").append(map.get("key")).append(": ").append(map.get("oldValue")).append("\n");
                    result.append("  + ").append(map.get("key")).append(": ").append(map.get("newValue")).append("\n");
                    break;
                default:
                    break;
            }
        }
        result.append("}");
        return result.toString();
    }
}
