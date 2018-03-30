package validator.rule.builders;

import validator.rule.builders.csv.reader.CsvRuleBuilder;
import validator.rule.builders.json.reader.JsonRuleBuilder;
import validator.rule.builders.rule.issuer.IssuerRuleBuilder;
import validator.rule.builders.txt.reader.TxtIRuleBuilder;

import java.util.List;
import java.util.Map;

/**
 * Application of design pattern: Factory
 * Class is responsible for returning proper file reader according to file extension
 * Possibility of implementing further file readers
 */
public class FactoryRuleBuilder {

    public static List<Map<String, String>> createReader(String filePath) {
        IRuleBuilder issuerReader;
        if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".txt")) {
            issuerReader = new TxtIRuleBuilder(filePath);
        } else if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".csv")) {
            issuerReader = new CsvRuleBuilder(filePath);
        } else if (filePath != null && !filePath.isEmpty() && filePath.endsWith(".json")) {
            issuerReader = new JsonRuleBuilder(filePath);
        } else {
            issuerReader = new IssuerRuleBuilder();
        }
        return issuerReader.readCards();
    }
}
