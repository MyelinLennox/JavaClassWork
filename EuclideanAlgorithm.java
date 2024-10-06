public class EuclideanAlgorithm {
    // Myelin Lennox, program to find the greatest common factor of two numbers using the Euclidean Algorithm
    public static void main(String[] args) {
        // Declare variables
        int quotient = 0;
        int remainder = -1;
        int x = 145;
        int y = 87;

        // Yes I know I know using while true is sloppy but in this case its the only thing the program does so its fine
        while (true) {
            // Calculate quotient and remainder
            quotient = x / y;
            remainder = x % y;

            // Check if remainder is 0 aka greatest common factor is found
            if (remainder == 0) {
                System.out.println("Greatest common factor is " + y);
                break;
            }

            // prepare for next iteration if remainder is not 0
            x = y;
            y = remainder;
        }
    }
}