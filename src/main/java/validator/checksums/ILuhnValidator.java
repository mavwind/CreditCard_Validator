package validator.checksums;

public interface ILuhnValidator {
    boolean isLuhnCorrect(String cardNo);
}
