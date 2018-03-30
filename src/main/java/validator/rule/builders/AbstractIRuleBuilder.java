package validator.rule.builders;

import java.util.List;
import java.util.Map;

public abstract class AbstractIRuleBuilder implements IRuleBuilder {

    protected String pathToFile;

    protected AbstractIRuleBuilder(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public abstract List<Map<String, String>> readCards();
}
