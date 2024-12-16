// Myelin Lennox, program to keep track of numbers 1-100
// Improt scanner and ArrayList
import java.util.ArrayList;
import java.util.Scanner;

class oneThroughOneHundredCounter {
    // Main to initilized rest of script
    public static void main(String[] args) {
        // Define scanner and array list
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        // Execute the request method
        request(list, input);
    }

    // Request
    public static void request(ArrayList<Integer> list, Scanner input) {
        // Ask for a number 1-100 then save it
        System.out.println("Enter a number 1-100:");
        int number = input.nextInt();
        
        // Make sure number is 1-100
        if (number < 1 || number > 100) {
            System.out.println("Please enter a valid number between 1 and 100.");
        } else {
            // Add the numver to the list then load the method to visualize it
            list.add(number);
            render(list, input);
        }
    }

    // Visualization
    public static void render(ArrayList<Integer> list, Scanner input) {
        // Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // For every number between 1-100, skipping by 20
        for (int i = 0; i < 100; i += 20) {
            // Print title
            System.out.print(i + "-" + (i+20) + ": ");
            
            // Check if there is a number in the list that belongs to this range
            for (int j = 0; j < list.size(); j++) {
                // Recall all in list
                if (list.get(j) >= i && list.get(j) < i + 20) {
                    System.out.print("*");  // Print a *
                }
            }
            // Print spacer
            System.out.println();
        }
        // Go back to request method to continue loop
        request(list, input);
    }
}
