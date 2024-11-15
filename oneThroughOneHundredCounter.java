import java.util.ArrayList;
import java.util.Scanner;

class OneThroughOneHundredCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.println("Enter a number 1-100:");
        int number = input.nextInt();
        
        // Validate input
        if (number < 1 || number > 100) {
            System.out.println("Please enter a valid number between 1 and 100.");
        } else {
            list.add(number);
            render(list);
        }
    }

    public static void render(ArrayList<Integer> list) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < 100; i += 20) {
            System.out.print(i + ": ");
            
            // Check if there is a number in the list that belongs to this range
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);
                if (num >= i && num < i + 20) {
                    System.out.print("*");  // Print a "*" if the number is in the range
                }
            }
            System.out.println();
        }
    }
}
