//Myelin Lennox, program to order pizzas
import java.util.Scanner;

class Pizza {
    // Varibles related to ording the pizza
    int pizzaSize;
    int pizzaToppings;
    int drinkCount;
    int drinkSize;
    int orderLocation;

    // Method to handle ordering
    void Order() {
        // Define scanner
        Scanner input = new Scanner(System.in);

        // Get pizza size
        System.out.println("What size would you like the pizza to be? (1 for small, 2 for medium, 3 for large)");
        pizzaSize = input.nextInt();

        // Get topping count
        System.out.println("How many toppings do you want on your pizza?");
        pizzaToppings = input.nextInt();
       
        // Get drink count
        System.out.println("How many drinks do you want");
        drinkCount = input.nextInt();

        // If there are drinks ask for size otehrwise set to 0
        if (drinkCount > 0) {
            System.out.println("What size do you want your drinks to be? (1 for small, 2 for medium, 3 for large)");
            drinkSize = input.nextInt();
        } else {
            drinkSize = 0;
        }

        // Save order location (does not affect total price)
        System.out.println("Is this dine in, pick up, or delivery? (1 for dine in, 2 for pick up, 3 for delivery)");
        orderLocation = input.nextInt();
    }
    
    // Method to handle cost calculation
    void calcCost() {
        // Add together all items prices multiplied by the size
        double total = (6.0*pizzaSize) + (.25*pizzaToppings) + (4*drinkCount*drinkSize);
        // Print total
        System.out.println("your total is: " + total);
    }
}

// Main class
class PizzaRestaurant {
    public static void main(String[] args) {
        // Initilize Pizza class
        Pizza Pizza = new Pizza();
        
        // Call the order method then claculate the cost
        Pizza.Order();
        Pizza.calcCost();
    }
}