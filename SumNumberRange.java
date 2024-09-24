// Myelin Lennox, program to calculate the sum of numbers in a range
import java.util.Scanner;

public class SumNumberRange {
    public static void main(String[] args) {
        // Declare scanner to get console input
        Scanner scanner = new Scanner(System.in);

        // Get First number in range
        System.out.println("Enter the first number in the range: ");
        int firstNumber = scanner.nextInt();

        // Get Second number in range
        System.out.println("Enter the second number in the range: ");
        int secondNumber = scanner.nextInt();

        int total = 0;
        
        // Loop through the range of numbers and add them to the total
        for (; firstNumber <= secondNumber; firstNumber++) {
            // Add the current number to the total
            total += firstNumber;
        }
        
        System.out.println("Total is: " + total);
    }
}