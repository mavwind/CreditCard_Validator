package validator;

import org.junit.Assert;
import org.junit.Test;

public class CardValidatorTest {

    @Test
    public void testValidateCardNumber() {
        final String cardNo = "5165201688668791";
        ICardValidator validator = new CardValidator();

        ValidationResult result = validator.validateCardNo(cardNo, null);

        Assert.assertEquals("Master Card", result.getIssuer());
        Assert.assertTrue(result.isLuhnPassed());
        Assert.assertEquals(true, result.isLuhnPassed());
    }

    @Test
    public void testValidateCardNumberUNKNOWN() {
        final String cardNo = "9911111111111111";
        ICardValidator validator = new CardValidator();

        ValidationResult result = validator.validateCardNo(cardNo, null);

        Assert.assertEquals("UNKNOWN", result.getIssuer());
        Assert.assertFalse(result.isLuhnPassed());
        Assert.assertEquals(false, result.isLuhnPassed());
    }

}