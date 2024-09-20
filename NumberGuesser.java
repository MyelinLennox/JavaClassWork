// Myelin Lennox, advanced number guessing game
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        // Define scanner
        Scanner input = new Scanner(System.in);

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
            System.out.println("How high do you want to guess?");
            if (input.hasNextInt()) {
                initialGuessSize = input.nextInt();

                // if input is negitive or 0
                if (initialGuessSize <= 0) {
                    System.out.println("Please enter a positive integer.");
                    initialGuessSize = -1;
                }

                // if input is not an integer
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                input.next();
            }
        } while (initialGuessSize <= 0);

        // Ask user for number to guess
        do {
            System.out.println("Enter a number between 1 and " + initialGuessSize + ":");
            if (input.hasNextInt()) {
                number = input.nextInt();

                // if input is out of range
                if (number <= 0 || number > initialGuessSize) {
                    System.out.println("Please enter a valid number between 1 and " + initialGuessSize + ".");
                    number = -1;
                }

                // if input is not an integer
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                input.next();
            }
        } while (number <= 0);

        // set highest value from user input
        high = initialGuessSize;

        // Binary search algorithm
        do {
            // add range for next guess
            guess = (low + high) / 2;
            guessCount++;

            // Ask user if guess is correct, higher, or lower
            System.out.println("Is your number 'on', 'higher', or 'lower' than " + guess + "?");

            // Capture response use .toLowerCase() to accept more inputs
            response = input.next().toLowerCase();

            // Response handling
            switch (response) {
                case "on":
                    if (guess == number) {
                        // Only break if the user confirms and guess matches
                        break;
                    } else {
                        System.out.println("I dont think so...");
                        lieCount++;
                        response = "";  // Force loop to continue
                    }
                    break;

                case "lower":
                    if (guess <= low) {
                        // user lied, reset range, add to counter
                        lieCount++;
                        low = 1;
                    } else {
                        // subtract 1 to avoid repeating guess
                        high = guess - 1;
                    }
                    break;

                case "higher":
                    if (guess >= high) {
                        // user lied, reset range, add to counter
                        lieCount++;
                        high = initialGuessSize;
                    } else {
                        // add 1 to avoid repeating guess
                        low = guess + 1;
                    }
                    break;

                default:
                    // invalid response
                    System.out.println("Please respond with 'on', 'higher', or 'lower'.");
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

        System.out.println("Your number is " + guess + "!");
        System.out.println("I got it in " + guessCount + " guesses.");

        // if user lied show lie count
        if (lieCount > 0) {
            System.out.println("You lied " + lieCount + " times.");
        }

        input.close();
    }
}
