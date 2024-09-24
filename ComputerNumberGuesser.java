// Myelin Lennox, advanced number guessing game that plays itself
import java.util.Random;
import java.util.Scanner;

public class ComputerNumberGuesser {

    // Define red ANSI color code
    public static final String ANSI_RED = "\u001B[31m";

    // Define green ANSI color code
    public static final String ANSI_GREEN = "\u001B[32m";

    // Define reset ANSI color code
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        // Define scanner
        Scanner input = new Scanner(System.in);

        // Define random number generator
        Random rand = new Random();


        // Decalre variables
        int lieCount = 0;
        int guessCount = 0;
        int initialGuessSize = -1;

        int low = 1;
        int high;

        int number = -1;
        int guess;

        String response = "";

        // Ask user for range to guess
        do {
            System.out.println(ANSI_RED + "How high do you want to guess?" + ANSI_RESET);

            // Generate random Limit number
            initialGuessSize = rand.nextInt(100);
            System.out.println(ANSI_GREEN + initialGuessSize + ANSI_RESET);



        } while (initialGuessSize <= 0);

        // Ask user for number to guess
        do {
            System.out.println(ANSI_RED + "Enter a number between 1 and " + initialGuessSize + ":" + ANSI_RESET);

            // Generate random number to guess for 
            number = rand.nextInt(initialGuessSize);
            System.out.println(ANSI_GREEN + "\033[3m" + number + " - hidden" + "\033[0m" + ANSI_RESET);


        } while (number <= 0);

        // set highest value from user input
        high = initialGuessSize;

        // Binary search algorithm
        do {
            // add range for next guess
            guess = (low + high) / 2;
            guessCount++;

            // Ask user if guess is correct, higher, or lower
            System.out.println(ANSI_RED + "Is your number 'on', 'higher', or 'lower' than " + guess + "?" + ANSI_RESET);

            // Handel logic for response
            if (guess == number) {
                response = "on";
            } else if (guess < number) {
                response = "higher";
            } else {
                response = "lower";
            }

            System.out.println(ANSI_GREEN + response + ANSI_RESET);
            

            // Response handling
            switch (response) {
                case "on":
                    if (guess == number) {
                        // Only break if the user confirms and guess matches
                        break;
                    }
                    break;

                case "lower":
                    // subtract 1 to avoid repeating guess
                    high = guess - 1;
                    break;

                case "higher":
                    // add 1 to avoid repeating guess
                    low = guess + 1;
                    break;
            }

            // if range is stuck, reset
            if (low > high) {
                low = 1;
                high = initialGuessSize;
            }

            // Debug to see current range V
            //System.out.println("Current range: " + low + " to " + high);

        } while (!response.equals("on") || guess != number);

        System.out.println(ANSI_RED + "Your number is " + guess + "!");
        System.out.println("I got it in " + guessCount + " guesses." + ANSI_RESET);


        input.close();
    }
}
