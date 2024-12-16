// Myelin Lennox, program to remove vowels from a string
import java.util.Scanner;

public class StringManipulation1 {
    public static void main(String[] args) {
        // Declare scanner
        Scanner input = new Scanner(System.in);

        // Request user input
        System.out.println("Enter a string: ");
        String inputedString = input.nextLine();

        // Declare array of vowels
        String[] vowels = {"a", "e", "i", "o", "u", "w", "y", "A", "E", "I", "O", "U", "W", "Y"};
        String editedString = inputedString;

        // Remove vowels from the string
        for (String vowel : vowels) {
            editedString = editedString.replace(vowel, "");
        }

        // Print output
        System.out.println("String after removing vowels: " + editedString);
    }
}
