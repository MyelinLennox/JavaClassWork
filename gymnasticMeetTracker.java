// Myelin Lennox, program to keep track of gym meet
import java.util.Scanner;

public class gymnasticMeetTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Define 2D array for keepign track of score for each ativity
        double[][] scores = new double[20][5];

        // Define count of gymnasts
        int gymnastCount = 0;
        int finalGymnastCount = 0;

        // Repeat if the count is invalid
        do {
            // Request input
            System.out.println("Enter the number of gymnasts competing (up to 20): ");
            gymnastCount = input.nextInt();

            // If input is real accept it and move on otherwise loop again
            if (gymnastCount > 0 && gymnastCount < 20) {
                finalGymnastCount = gymnastCount;
            } else {
                System.out.println("Invalid number");
            }
        } while (finalGymnastCount == 0);

        // Input scores for each gymnast
        for (int i = 0; i < gymnastCount; i++) {
            // Header
            System.out.println("Enter scores for gymnast " + (i + 1) + ":");

            // Vault
            System.out.print("Vault: ");
            scores[i][0] = input.nextDouble();

            // Bars
            System.out.print("Bars: ");
            scores[i][1] = input.nextDouble();

            // Beam
            System.out.print("Beam: ");
            scores[i][2] = input.nextDouble();

            // Floor
            System.out.print("Floor: ");
            scores[i][3] = input.nextDouble();

            // add each score together for each gymnsat
            scores[i][4] = scores[i][0] + scores[i][1] + scores[i][2] + scores[i][3];
        }

        // Find the winner
        double highestTotal = 0;
        int winningGymnast = -1;

        // Find the winner by loopign through all scores
        for (int i = 0; i < gymnastCount; i++) {
            if (scores[i][4] > highestTotal) {
                highestTotal = scores[i][4];
                winningGymnast = i;
            }
        }

        // Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Display Header
        System.out.println("\nThe results are:");
        System.out.println();

        // Dispaly results
        for (int i = 0; i < gymnastCount; i++) {
            System.out.println(scores[i][0] + " " + scores[i][1] + " " + scores[i][2] + " " + scores[i][3] + " " + scores[i][4]);
        }

        System.out.println();
        System.out.println("The winning total is " + highestTotal + " by gymnast " + (winningGymnast + 1));

        input.close();
    }
}
