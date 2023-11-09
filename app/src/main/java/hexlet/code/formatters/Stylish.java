package hexlet.code.formatters;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> list) {
        StringBuilder result = new StringBuilder("{\r\n");
        for (Map<String, Object> map: list) {
            switch (map.get("event").toString()) {
                case "removed":
                    result.append("  - ").append(map.get("key")).append(": ").append(map.get("value")).append("\r\n");
                    break;
                case "not changed":
                    result.append("    ").append(map.get("key")).append(": ").append(map.get("value")).append("\r\n");
                    break;
                case "added":
                    result.append("  + ").append(map.get("key")).append(": ").append(map.get("value")).append("\r\n");
                    break;
                case "updated":
                    result.append("  - ").append(map.get("key")).append(": ")
                            .append(map.get("oldValue")).append("\r\n");
                    result.append("  + ").append(map.get("key")).append(": ")
                            .append(map.get("newValue")).append("\r\n");
                    break;
                default:
                    break;
            }
        }
        result.append("}");
        return result.toString();
    }
}
