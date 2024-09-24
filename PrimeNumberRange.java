import java.util.Scanner;

public class PrimeNumberRange {
    public static void main(String[] args) {
        // Declare scanner to get console input
        Scanner scanner = new java.util.Scanner(System.in);

        // Get the largest number in the range
        System.out.println("Enter the largest number in the range: ");
        int largest = scanner.nextInt();

        // Iterate through teh range of numbers specified
        for (int i=0; i <= largest; i++) {

            // Check if the number is prime (not divisible by any number other than 1 and itself)
            for (int j=2; j < i; j++) {
                
                // If the number is divisible by any number other than 1 its not prime
                if (i % j == 0) {
                    break;
                }

                if (j == i - 1) {
                    System.out.println(i);
                }
            }
        }

    }
}