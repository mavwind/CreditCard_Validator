package validator.checksums;

import org.junit.Assert;
import org.junit.Test;

public class LuhnValidatorImpTest {


    @Test
    public void testVerify() {
        String cardNo = "18606";

        ILuhnValidator checksumVerifier = new LuhnValidatorImp();
        boolean result = checksumVerifier.isLuhnCorrect(cardNo);

        Assert.assertTrue(result);
    }

    @Test
    public void testVerifyNegatively() {
        String cardNo = "18605";
        ILuhnValidator checksumVerifier = new LuhnValidatorImp();

        boolean result = checksumVerifier.isLuhnCorrect(cardNo);

        Assert.assertFalse(result);
    }

    @Test
    public void testVerifyPositive() {
        String cardNo = "1412";
        ILuhnValidator checksumVerifier = new LuhnValidatorImp();

        boolean result = checksumVerifier.isLuhnCorrect(cardNo);

        Assert.assertTrue(result);
    }

    @Test
    public void testVerifyNeg2() {
        String cardNo = "2421";
        ILuhnValidator checksumVerifier = new LuhnValidatorImp();

        boolean result = checksumVerifier.isLuhnCorrect(cardNo);

        Assert.assertFalse(result);
    }

}