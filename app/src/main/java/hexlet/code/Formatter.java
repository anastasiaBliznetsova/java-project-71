package hexlet.code;
import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String choosingFormatter(List<Map<String, Object>> map, String format)
            throws JsonProcessingException {
        switch (format) {
            case "stylish":
                return Stylish.stylish(map);
            case "plain":
                return Plain.plain(map);
            case "json":
                return Json.json(map);
            default:
                return "You entered an incorrect value";
        }
    }
}
