import java.util.Random;
import java.util.Scanner;

public class Exercise9 {
    public static final int GUESS_SIZE = 4;

    public static void main(String[] args) {
        Random rand = new Random();
        final String randomNumber = randomNum();
        int min = 5;
        int max = 25;
        int tries = 0;
        int diff = difficultyLevel();


        if (diff == 1) {
            tries = 20;
        } else if (diff == 2) {
            tries = 15;
        } else if (diff == 3) {
            tries = 10;
        } else {
            tries = rand.nextInt(max - min + 1) + min;
        }

        for (int i = 0; i <= tries; i++) {
            String guessInput = getInput();
            if (isDouble(guessInput)) {
                System.out.println("Two of the same number is not allowed , attempts will be reduced by 2");
                System.out.println(tries + " attempts are left");
                tries = tries - 2;
            } else {
                int value = gameStart(guessInput, randomNumber);
                System.out.println(guessInput + " - " + (value / 10) + " correct guess, " + (value % 10) + " half-correct guess");
                if (value == 40) {
                    System.out.println("You won with " + i + " attempts, the number was " + randomNumber);
                    return;
                }
                if (diff != 4) {
                    System.out.println(tries - i + " attempts are left.");
                }
            }
        }
        System.out.println("The number was " + randomNumber);
    }

    public static int gameStart(String guess, String random) {
        int correct = 0;
        int correctPos = 0;

        for (int i = 0; i < random.length(); i++) {
            int checkGuess = guess.indexOf(random.charAt(i));
            if (checkGuess == i)
                correctPos++;
            else if (checkGuess >= 0)
                correct++;
        }
        return correctPos * 10 + correct;
    }

    public static boolean isDouble(String strGuess) {
        int count = 0;
        for (int j = 0; j < strGuess.length(); j++) {
            boolean copy = true;
            while (copy) {
                copy = false;
                int check = strGuess.charAt(j);

                for (int k = 0; k < j; k++) {
                    if (strGuess.charAt(k) == check) {
                        copy = true;
                        break;
                    }
                }
                if (copy) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        long numLength = 1;
        System.out.println("Enter your guess: ");
        String strGuess = scanner.next();
        while (numLength <= strGuess.length()) {
            length++;
            numLength *= 10;
        }
        if (strGuess.length() > GUESS_SIZE || strGuess.length() < GUESS_SIZE) {
            System.out.println("Guess should be 4 digits only.");
            strGuess = getInput();
        }
        for (int i = 0; i < strGuess.length(); i++) {
            if (strGuess.charAt(i) > 53 || strGuess.charAt(i) < 49) {
                System.out.println("Guess can't have numbers greater than 5 or smaller than 1");
                strGuess = getInput();
                break;
            }
        }
        return strGuess;
    }

    public static int difficultyLevel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your preferred difficulty level of the game: 1 - 4 ");
        System.out.println("1 - Easy ( 20 attempts )");
        System.out.println("2 - Medium ( 15 attempts )");
        System.out.println("3 - Hard ( 10 attempts )");
        System.out.println("4 - Surprise ( 5-25 attempts )");
        int diff = scanner.nextInt();
        if (diff > 4 || diff < 1) {
            System.out.println("This difficulty level is invalid!");
            diff = difficultyLevel();
        }
        return diff;
    }

    public static String randomNum() {
        Random rand = new Random();
        int[] randomNumber = new int[GUESS_SIZE];
        String number = "";
        int min = 1;
        int max = 5;

        for (int i = 0; i < randomNumber.length; i++) {
            randomNumber[i] = rand.nextInt(max - min + 1) + min;
            boolean found = true;

            while (found) {
                found = false;

                int check = randomNumber[i];

                for (int j = 0; j < i; j++) {
                    if (randomNumber[j] == check) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    randomNumber[i] = rand.nextInt(max - min + 1) + min;
                }
            }

        }
        for (int k = 0; k < GUESS_SIZE; k++) {
            number += randomNumber[k];
        }
        return number;
    }
}