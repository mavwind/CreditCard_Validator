package validator.rule.builders.txt.reader;

import validator.rule.builders.AbstractIRuleBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class building rules from external Txt file
 */
public class TxtIRuleBuilder extends AbstractIRuleBuilder {

    public TxtIRuleBuilder(String pathToFile) {
        super (pathToFile);
    }

    private static final String RULE_SEPARATOR = ",";

    /**
     *
     * @return Card rules as Arraylist of Hashmaps, read from Txt file
     * Keys: "name" for issuer names, "prefix" for prefix, "length" for card number length
     */
    public List<Map<String, String>> readCards() {

        List<Map<String, String>> rulesList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] split = line.split(RULE_SEPARATOR);

                Map<String, String> tempMap = new HashMap<>();
                tempMap.put("name", split[0]);
                tempMap.put("prefix", split[1]);
                tempMap.put("length", split[2]);
                rulesList.add(tempMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rulesList;
    }
}
