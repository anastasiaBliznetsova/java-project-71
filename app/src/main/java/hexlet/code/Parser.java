package hexlet.code;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String content, String fileFormat) throws JsonProcessingException {
        if (fileFormat.substring(fileFormat.indexOf(".") + 1).equals("json")) {
            return new ObjectMapper().readValue(content, new TypeReference<>() { });
        } else {
            return new YAMLMapper().readValue(content, new TypeReference<>() { });
        }
    }
}
