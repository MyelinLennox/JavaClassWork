//Myelin Lennox, unit conversion program
import java.util.Scanner;

public class UnitConversion {
    public static void main(String[] args) {

        // Define scanner
        Scanner scanner = new Scanner(System.in);

        // Declare which conversion to use
        int choice = 0;

        // Use while to force user to pick a valid response
        while (choice == 0) {
            System.out.println("Which type of conversion would you like to perform?");
            System.out.println("1. Feet to Inches");
            System.out.println("2. Centimeters to Inches");
            System.out.println("3. Miles to Meters");
            System.out.println("4. Miles to Feet");
            System.out.println("5. Pounds to Ounces");
            System.out.println("6. Kilowatts to Horsepower");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                // Switch for user choice
                switch (choice) {
                    case 1:
                        FeetToInches(scanner);
                        break;

                    case 2:
                        CentimetersToInches(scanner);
                        break;

                    case 3:
                        MilesToMeters(scanner);
                        break;

                    case 4:
                        MilesToFeet(scanner);
                        break;

                    case 5:
                        PoundsToOunces(scanner);
                        break;

                    case 6:
                        KilowattsToHorsepower(scanner);
                        break;

                    default:
                        System.out.println("Response not in range.");
                        choice = 0;  // Reset choice if invalid input
                }
            } else {
                // Invalid input
                System.out.println("Invalid, enter a number.");
                scanner.next();
            }
        }
        scanner.close();  // Close scanner at the end
    }

    // Method to return a number from user input
    static double ReturnNumber(Scanner scanner) {
        double response = 0;

        while (response == 0) {
            if (scanner.hasNextDouble()) {
                response = scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear invalid input
            }
        }
        return response;
    }

    // Convert feet to inches
    static void FeetToInches(Scanner scanner) {
        // Ask user for input
        System.out.println("Enter distance in feet: ");
        //Use ReturnNumber method to get user input
        double feet = ReturnNumber(scanner);
        // Print conversion and reset
        System.out.println(feet + " feet is " + (feet * 12) + " inches.");
        main(null);
    }

    // Convert centimeters to inches
    static void CentimetersToInches(Scanner scanner) {
        // Ask user for input
        System.out.println("Enter distance in centimeters: ");
        //Use ReturnNumber method to get user input
        double centimeters = ReturnNumber(scanner);
        // Print conversion and reset
        System.out.println(centimeters + " centimeters is " + (centimeters / 2.54) + " inches.");
        main(null);
    }

    // Convert miles to meters
    static void MilesToMeters(Scanner scanner) {
        // Ask user for input
        System.out.println("Enter distance in miles: ");
        //Use ReturnNumber method to get user input
        double miles = ReturnNumber(scanner);
        // Print conversion and reset
        System.out.println(miles + " miles is " + (miles * 1609.34) + " meters.");
        main(null);
    }

    // Convert miles to feet
    static void MilesToFeet(Scanner scanner) {
        // Ask user for input
        System.out.println("Enter distance in miles: ");
        //Use ReturnNumber method to get user input
        double miles = ReturnNumber(scanner);
        // Print conversion and reset
        System.out.println(miles + " miles is " + (miles * 5280) + " feet.");
        main(null);
    }

    // Convert pounds to ounces
    static void PoundsToOunces(Scanner scanner) {
        // Ask user for input
        System.out.println("Enter weight in pounds: ");
        //Use ReturnNumber method to get user input
        double pounds = ReturnNumber(scanner);
        // Print conversion and reset
        System.out.println(pounds + " pounds is " + (pounds * 16) + " ounces.");
        main(null);
    }

    // Convert kilowatts to horsepower
    static void KilowattsToHorsepower(Scanner scanner) {
        // Ask user for input
        System.out.println("Enter power in kilowatts: ");
        //Use ReturnNumber method to get user input
        double kilowatts = ReturnNumber(scanner);
        // Print conversion and reset
        System.out.println(kilowatts + " kilowatts is " + (kilowatts * 1.34102) + " horsepower.");
        main(null);
    }
}
