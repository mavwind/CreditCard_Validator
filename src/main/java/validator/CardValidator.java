package validator;

import validator.checksums.ILuhnValidator;
import validator.checksums.LuhnValidatorImp;
import validator.issuers.IssuerDetector;
import validator.issuers.IssuerDetectorImp;

public class CardValidator implements ICardValidator {

    public ValidationResult validateCardNo(String cardNo, String filePath) {

        ValidationResult result = new ValidationResult();

        IssuerDetector detector = new IssuerDetectorImp();
        String issuer = detector.detectIssuer(cardNo, filePath);

        ILuhnValidator validator = new LuhnValidatorImp();
        boolean isLuhnPassed = validator.isLuhnCorrect(cardNo);

        result.setIssuer(issuer);
        result.setLuhnResult(isLuhnPassed);
        return result;
    }
}
