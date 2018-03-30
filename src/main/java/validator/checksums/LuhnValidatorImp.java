package validator.checksums;

public class LuhnValidatorImp implements ILuhnValidator {

    /**
     * Method validating credit card number using Luhn algorithm
     * @param cardNo - card number
     * @return true if the card number is correct, false otherwise
     */
    @Override
    public boolean isLuhnCorrect(String cardNo) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNo.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(cardNo.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
