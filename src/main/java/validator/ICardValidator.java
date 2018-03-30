package validator;

public interface ICardValidator {
    ValidationResult validateCardNo(String cardNo, String filePath);
}
