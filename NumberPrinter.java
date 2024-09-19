// Myelin Lenoox, program to find the largest, smallest, and average of three numbers
import java.util.Scanner;

public class NumberPrinter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for the first number
        System.out.println("Enter first number:");
        int firstNumber = input.nextInt();

        // Ask for the second number
        System.out.println("Enter second number:");
        int secondNumber = input.nextInt();

        // Ask for the third number
        System.out.println("Enter third number:");
        int thirdNumber = input.nextInt();

        // Get the largest number using "Math.max" (once embedded in another "Math.max" because it dosent accept more than 2 arguments)
        System.out.println("The largest Number is: " + Math.max(firstNumber, Math.max(secondNumber, thirdNumber)));

        // Get the smallest number using "Math.min" (once embedded in another "Math.min" because it dosent accept more than 2 arguments)
        System.out.println("The smallest Number is: " + Math.min(firstNumber, Math.min(secondNumber, thirdNumber)));

        // Use simple math to get the average
        System.out.println("The average is : " + (firstNumber + secondNumber + thirdNumber) / 3);
    }
}