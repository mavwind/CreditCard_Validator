package validator.issuers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IssuerDetectorImpTest {

    private final static String TXT_Path = "C:\\Users\\Sebastian\\IdeaProjects\\credit_card_validator\\src\\main\\files\\cards.txt";
    private final static String CSV_Path = "C:\\Users\\Sebastian\\IdeaProjects\\credit_card_validator\\src\\main\\files\\data.csv";
    private final static String JSON_Path = "C:\\Users\\Sebastian\\IdeaProjects\\credit_card_validator\\src\\main\\files\\Jcards.json";




    @Test
    public void testDetectIssuer() {
        final String cardNo = "372938861903137";

        IssuerDetectorImp issuerDetector = new IssuerDetectorImp();
        String resultTxt = issuerDetector.detectIssuer(cardNo, TXT_Path);
        String resultCsv = issuerDetector.detectIssuer(cardNo, CSV_Path);
        String resultJson = issuerDetector.detectIssuer(cardNo, JSON_Path);

        assertEquals("American Express", resultTxt);
        assertEquals("American Express", resultCsv);
        assertEquals("American Express", resultJson);
    }

}