package validator.issuers;

import validator.rule.builders.FactoryRuleBuilder;

import java.util.List;
import java.util.Map;

/**
 * Class has to call FactoryRuleBuilder, build list of rules and compare with credit card number.
 * If the rule matches the card number, method detectIssuer should return name of the issuer.
 */
public class IssuerDetectorImp implements IssuerDetector {

    @Override
    public String detectIssuer(String cardNo, String filePath) {

        List<Map<String, String>> rules = FactoryRuleBuilder.createReader(filePath);


            for (Map<String, String> rule : rules) {
                if (cardNo.startsWith(rule.get("prefix"))
                        && cardNo.length() == Integer.parseInt(rule.get("length"))) {
                    return rule.get("name");
                }
            }
            return "UNKNOWN";


        }
    }


