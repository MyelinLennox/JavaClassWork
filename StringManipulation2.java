// Myelin Lennox, program to read words from a file, convert each word to uppercase, split each word into two parts, and write the processed words to a file.
import java.io.*;
import java.util.*;

public class StringManipulation2 {
    // Main metheod
    public static void main(String[] args) throws IOException {
        // Read words from the input file
        List<String> words = readWords("StringManipulationInput.txt");

        // Convert each word to uppercase and split into two parts
        List<String> splitWords = new ArrayList<>();

        // Loop through each word
        for (String word : words) {
            // Convert to uppercase
            String upperWord = word.toUpperCase();
            // Divide the word into two parts (use .length() / 2 to split odd words)
            int splitSize = upperWord.length() / 2;

            // split the word in two then add to string
            splitWords.add(upperWord.substring(0, splitSize));
            splitWords.add(upperWord.substring(splitSize));
        }

        // Write the processed words to the output file in string order
        writeWords(splitWords, "StringManipulationOutput.txt");
        System.out.println("Done");
    }

    // REading words from file
    private static List<String> readWords(String fileName) throws IOException {
        // Define list, buffered reader (for reading file), and string for line
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        // Read entire content of the file as a single string
        String line = reader.readLine();
        
        // Split content into words and add them to the list if lien is not empty
        if (line != null) {
            String[] splitWords = line.split(" ");
            // Add all words to the list
            for (String word : splitWords) {
                words.add(word);
            }
        }
        reader.close();
        return words;
    }

    // Writing words to file
    private static void writeWords(List<String> words, String fileName) throws IOException {
        // Define buffered writer for writing to file
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        // Loop through each word
        for (String word : words) {
            // Write to fiel
            writer.write(word);
            // Next line
            writer.newLine();
        }
    }
}
