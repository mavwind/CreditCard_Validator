package validator.rule.builders.rule.issuer;


import validator.rule.builders.IRuleBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class responsible for building rules in case there is no external file available
 */
public class IssuerRuleBuilder implements IRuleBuilder {

    private static Map<String, String> createRule(String name, String length, String prefix) {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", name);
        tempMap.put("length", length);
        tempMap.put("prefix", prefix);
        return tempMap;
    }

    @Override
    public List<Map<String, String>> readCards() {
        List<Map<String,String>> issuerRules = new ArrayList<>();

        issuerRules.add(createRule("Master Card", "16", "51"));
        issuerRules.add(createRule("Master Card", "16", "52"));
        issuerRules.add(createRule("Master Card", "16", "53"));
        issuerRules.add(createRule("Master Card", "16", "54"));
        issuerRules.add(createRule("Master Card", "16", "55"));
        issuerRules.add(createRule("Visa", "16", "4"));
        issuerRules.add(createRule("American Express", "15", "34"));
        issuerRules.add(createRule("American Express", "15", "37"));


        return issuerRules;
    }
}
