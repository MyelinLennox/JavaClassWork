// Myelin Lennox, Program to make a visual multiplication table
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Define scanner
        Scanner scanner = new Scanner(System.in);

        // Get user input for the size of the multiplication table
        System.out.print("Enter the size of the multiplication table: ");
        int n = scanner.nextInt();

        // Print column headers
        System.out.print("   |");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
        }
        // Move to the next line
        System.out.println();

        // Print separator line
        System.out.print("---+");
        for (int i = 1; i <= n; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Outer loop for rows
        for (int i = 1; i <= n; i++) {
            // Print row header (the number on the left)
            System.out.printf("%2d |", i);

            // Inner loop for columns (multiplying the row number by the column number)
            for (int j = 1; j <= n; j++) {
                // Print product with formatting
                System.out.printf("%4d", i * j);
            }
            // Move to the next row
            System.out.println();
        }
        // Close the scanner
        scanner.close();
    }
}
