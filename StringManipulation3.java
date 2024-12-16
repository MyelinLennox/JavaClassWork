// Myelin Lennox, Program to shift the letters in a string
import java.util.Scanner;

public class StringManipulation3 {
    public static void main(String[] args) {
        // Define scanner and letters array
        Scanner input = new Scanner(System.in);
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        // Request user input for a string and set that string to an object
        System.out.println("Enter a string to encrypt: ");
        String encryptInputString = input.nextLine();

        // Request user input for an offset (will be 5 for example)
        System.out.println("Enter a offset for encryption: ");
        int encryptOffset = input.nextInt();

        // Loop for each letter in given string
        for (int i = 0; i < encryptInputString.length(); i++) {
            // Loop for each letter in the letters array
            for (int j = 0; j < letters.length; j++) {
                // Ift The letter matches the letter in the string (letters[j].charAt(0) is the letter in the array)
                if (encryptInputString.charAt(i) == letters[j].charAt(0)) {
                    // Print the letter in the array that is offset
                    System.out.print(letters[(j + encryptOffset) % letters.length]);
                }
            }
        }

        // Space and clear buffer
        System.out.println();
        input.nextLine();

        // Request user input for a string and set that string to an object
        System.out.println("Enter a string to decrypt: ");
        String decryptInputString = input.nextLine();

        // Request user input for an offset (will be 5 for example)
        System.out.println("Enter a offset for decryption: ");
        int decryptOffset = input.nextInt();

        // Loop for each letter in given string
        for (int i = 0; i < decryptInputString.length(); i++) {
            // Loop for each letter in the letters array
            for (int j = 0; j < letters.length; j++) {
                // Ift The letter matches the letter in the string (letters[j].charAt(0) is the letter in the array)
                if (decryptInputString.charAt(i) == letters[j].charAt(0)) {
                    // Print the letter in the array that is offset
                    System.out.print(letters[(j - decryptOffset) % letters.length]);
                }
            }
        }
    }   
}