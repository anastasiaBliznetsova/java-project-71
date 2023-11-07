package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    public static ObjectMapper parser(String file) {
        if (file.substring(file.indexOf(".") + 1).equals("json")) {
            return new ObjectMapper();
        } else {
            return new YAMLMapper();
        }
    }
}
