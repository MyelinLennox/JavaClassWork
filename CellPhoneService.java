// Myelin Lennox, program to find best cell phone plan
import java.util.Scanner;

public class CellPhoneService {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input for talk minutes
        System.out.print("Enter maximum monthly talk minutes: ");
        int talkMinutes = input.nextInt();

        // Get user input for text messages
        System.out.print("Enter maximum monthly text messages: ");
        int textMessages = input.nextInt();

        // Get user input for data usage
        System.out.print("Enter maximum monthly gigabytes of data: ");
        double dataUsage = input.nextDouble();

        // Determine the best plan, this logic acts like a "tree" filtering down the best plan
        if (dataUsage > 0) {
            if (dataUsage < 3) {
                System.out.println("Use plan E at $79");
            } else {
                System.out.println("Use plan F at $87");
            }
        } else if (talkMinutes >= 500) {
            if (textMessages < 100) {
                System.out.println("Use plan C at $61");
            } else {
                System.out.println("Use plan D at $70");
            }
        } else {
            if (textMessages == 0) {
                System.out.println("Use plan A at $49");
            } else {
                System.out.println("Use plan B at $55");
            }
        }

    }
}
