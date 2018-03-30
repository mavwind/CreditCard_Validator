package validator;

import java.util.Scanner;

/**
 * Application validates credit card number given by user.
 * Three types of cards are recognized (Master Card, Visa and American Express)
 * Rules are read from file (card issuer, prefix and and card length)
 */
public class App {

    private final static String TXT_Path = "C:\\Users\\Sebastian\\IdeaProjects\\credit_card_validator\\src\\main\\files\\cards.txt";
    private final static String CSV_Path = "C:\\Users\\Sebastian\\IdeaProjects\\credit_card_validator\\src\\main\\files\\data.csv";
    private final static String JSON_Path = "C:\\Users\\Sebastian\\IdeaProjects\\credit_card_validator\\src\\main\\files\\Jcards.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card number");
        String cardNo = scanner.next();
        ICardValidator validator = new CardValidator();
        //ValidationResult result = validator.validateCardNo(cardNo, TXT_Path);
        //ValidationResult result = validator.validateCardNo(cardNo, CSV_Path);
        ValidationResult result = validator.validateCardNo(cardNo, JSON_Path);
        System.out.println("ISSUER: " + result.getIssuer());
        System.out.println("LUHN PASSED: " + result.isLuhnPassed());


    }

}

//TODO: create more tests


