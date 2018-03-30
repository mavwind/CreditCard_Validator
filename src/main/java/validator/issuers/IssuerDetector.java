package validator.issuers;

public interface IssuerDetector {
    String detectIssuer(String cardNo, String filePath);

}
