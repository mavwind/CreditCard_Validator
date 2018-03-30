package validator.rule.builders.json.reader;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import validator.rule.builders.AbstractIRuleBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class building rules from external Json file
 */
public class JsonRuleBuilder extends AbstractIRuleBuilder {

    public JsonRuleBuilder(String pathToFile) {
        super(pathToFile);
    }

    /**
     *
     * @return Card rules as Arraylist of Hashmaps, read from Json file.
     * Keys: "name" for issuer names, "prefix" for prefix, "length" for card number length
     */
    @Override
    public List<Map<String, String>> readCards() {

        List<Map<String, String>> jsonMap = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(pathToFile));
            JSONArray jsons = (JSONArray) jsonObject.get("cards");
            for (Object j : jsons) {
                jsonMap.add(mapper.readValue(j.toString(),
                        new TypeReference<Map<String, String>>() {
                        }));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return jsonMap;
    }
}
