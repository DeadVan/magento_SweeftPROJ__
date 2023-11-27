package baseDir.utils;

import dto.AccountDto;
import org.testng.annotations.DataProvider;

import java.util.Random;

public abstract class RandomUtils {
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz";
    public static final int NUM_LETTERS_IN_ALPHABET = 26;
    public static final int NUM_DIGITS = 10;
    public static AccountDto firstAccount;
    public static AccountDto secondAccount;
    public static AccountDto thirdAccount;
    public static String generateString(int length, int numCapitalLetters, int numNumbers) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        if (length < numCapitalLetters + numNumbers) {
            System.out.println("length must be higher than sum of other arguments");
        } else {
            for (int i = 0; i < length - numCapitalLetters - numNumbers; i++) {
                int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
                char c = ALPHA_NUMERIC_STRING.charAt(index);
                builder.append(c);
            }
            for (int i = 0; i < numCapitalLetters; i++) {
                char c = (char) (random.nextInt(NUM_LETTERS_IN_ALPHABET) + 'A');
                builder.append(c);
            }
            for (int i = 0; i < numNumbers; i++) {
                int num = random.nextInt(NUM_DIGITS);
                builder.append(num);
            }
        }
        return builder.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @DataProvider(name = "registrationData")
    public static Object[][] getRegData() {
        firstAccount = new AccountDto(generateString(7,0,0),generateString(7,0,0),generateString(6,0,0)+"@gmail.com",generateString(8,1,1));
        secondAccount = new AccountDto(generateString(7,0,0),generateString(7,0,0),generateString(6,0,0)+"@gmail.com",generateString(8,1,1));
        thirdAccount = new AccountDto(generateString(7,0,0),generateString(7,0,0),generateString(6,0,0)+"@gmail.com",generateString(8,1,1));
        LogUtils.info(firstAccount.toString() + "||" + secondAccount.toString() + "||" + thirdAccount.toString());
        return new Object[][] {
//                {firstAccount.getFirstName(),firstAccount.getLastName(),firstAccount.getEmail(),firstAccount.getPassword()},
//                {secondAccount.getFirstName(),secondAccount.getLastName(),secondAccount.getEmail(),secondAccount.getPassword()},
                {thirdAccount.getFirstName(),thirdAccount.getLastName(),thirdAccount.getEmail(),thirdAccount.getPassword()}
        };
    }
}
