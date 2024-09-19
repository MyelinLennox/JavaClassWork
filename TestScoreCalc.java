//Myelin Lennox, program to calculate the grade of a test score
import java.util.Scanner;

public class TestScoreCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for the test score
        System.out.println("Enter test score:");

        // Get the test score
        int testScore = input.nextInt();

        // Go down the line of if statements to find the correct grade
        if (testScore >= 90) {
            System.out.println("You got a A!");
        } else if (testScore >= 80) {
            System.out.println("You got a B!");
        } else if (testScore >= 70) {
            System.out.println("You got a C!");
        } else if (testScore >= 60) {
            System.out.println("You got a D.");
        } else {
            System.out.println("You got a F.  :(");
        }
    }
}