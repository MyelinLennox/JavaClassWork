// Myelin Lennox, program to calculate the number of twenties, tens, fives, and ones in a given dollar amount
import java.util.Scanner;

public class Dollars {
    public static void main(String[] args) {
        // Decalre scanner to interprate console input
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter dollar amount:");

        //Use nextInt() to read dollar amount as int instead of string
        int amount = scanner.nextInt();
        
        //Declare 20, 10, 5, and 1 dollar bills
        int twenties = amount / 20;

        // Use the modulus operator to get the remainder "%=" is the operator, "20" is the divide amount
        amount %= 20;
        
        int tens = amount / 10;
        amount %= 10;
        
        int fives = amount / 5;
        amount %= 5;
        
        // Put all of the remaining dollars into thhe ones
        int ones = amount;
        
        // Print bill amounts
        System.out.println("Twenties: " + twenties);
        System.out.println("Tens: " + tens);
        System.out.println("Fives: " + fives);
        System.out.println("Ones: " + ones);
    }
}