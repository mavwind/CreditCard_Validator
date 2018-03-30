package validator;

public class ValidationResult {
    private String issuer;
    private boolean luhnResult = false;



    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Boolean isLuhnPassed() {
        return luhnResult;
    }

    public void setLuhnResult(Boolean luhnResult) {
        this.luhnResult = luhnResult;
    }
}
