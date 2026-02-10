package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataDriven {

    public static JsonNode jsonReader(String key) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/testData/testData.json");
        JsonNode rootNode = objectMapper.readTree(file);
        return rootNode.get(key);
    }
}
