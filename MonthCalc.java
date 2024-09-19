//Myelin Lennox, program to calculate the number of days in a month
import java.util.Scanner;

public class MonthCalc {
    public static void main(String[] args) {
        // Create scanner for  console iput
        Scanner input = new Scanner(System.in);

        // Request month
        System.out.println("Enter Month: ");

        String month = input.nextLine();

        // Request year
        System.out.println("Enter Year: ");

        int year = input.nextInt();

        // Close scanner to save memory
        input.close();

        // Define -1 as default
        int days = -1;

        // Case Switch "days" is the varible, "switch" the operator, "month" is the variable to read 
        days = switch (month) {
            // Static 31 day months
            case "january", "march", "may", "july", "august", "october", "december" -> {
                yield 31;
            }
            // Static 30 day months
            case "april", "june", "september", "november" -> {
                yield 30;
            }
            // February (leap)
            case "february" -> {
                // Check if its a leap year by dividing by 4 and seeing if theres a remainder
                if (year % 4 == 0) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            // If it fails use -1
            default -> {
                yield -1;
            }
        };

        // Use -1 as a common error code if the month is wrong (for example using a number instead of a month name)
        if (days == -1) {
            System.out.println("Invalid month");
        } else {
            System.out.println("There are " + days + " days in " + month + " of " + year);
        }
    }
}