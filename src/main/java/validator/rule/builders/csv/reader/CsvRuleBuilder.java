package validator.rule.builders.csv.reader;

import validator.rule.builders.AbstractIRuleBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class building rules from external Csv file
 */
public class CsvRuleBuilder extends AbstractIRuleBuilder {


    public CsvRuleBuilder(String pathToFile) {
        super(pathToFile);
    }

    private static final String RULE_SEPARATOR = ";";

    /**
     * @return Card rules as Arraylist of Linked Hashmaps, read from Csv file.
     * Keys: "name" for issuer names, "prefix" for prefix, "length" for card number length
     */
    @Override
    public List<Map<String, String>> readCards() {
        List<Map<String, String>> rulesList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {

            String line = bufferedReader.readLine();
            String[] lineHeader = line.split(RULE_SEPARATOR);


            while ((line = bufferedReader.readLine()) != null) {

                String[] split = line.split(RULE_SEPARATOR);


                Map<String, String> tempMap = new LinkedHashMap<>();
                for (int i = 0; i < split.length; i++) {
                    tempMap.put(lineHeader[i], split[i]);
                }
                rulesList.add(tempMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rulesList;
    }
}

