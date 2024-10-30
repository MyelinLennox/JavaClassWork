
// Myelin Lennox, employee salary and information "calculator"
import java.util.Scanner;

class Employee {
    // private varibles saved
    int savedEmployeeId;
    Double savedSalary;
    int savedWorkedYears;
    double savedRaisePercent;
    
    void NewEmployee(int employeeId, double salary, int workedYears, double raisePercent) {
        // Save to class
        System.out.println("Employee ID: " + employeeId);
        savedEmployeeId = employeeId;

        // Save to class
        System.out.println("Employee salary: " + salary);
        savedSalary = salary;

        // Save to class
        System.out.println("Employee years worked: " + workedYears);
        savedWorkedYears = workedYears;

        // Save to class
        System.out.println("added raise percent: " + raisePercent + "%");
        savedRaisePercent = raisePercent;
    }

    void Anniversary() {
        // Just bump up number of saved work years
        savedWorkedYears++;
        System.out.println("Employee has worked " + savedWorkedYears + " years.");
    }

    void YouGotARaise() {
        // Add the percent of the salary to the salary
        savedSalary += savedSalary * savedRaisePercent;
        System.out.println("New salary is: " + savedSalary);
    }
    
    void YouGetABonus() {
        // Multiply by 1.05 if years worked is less than 10 else if is equal to or more than 10 multiply by 1.1
        if (savedWorkedYears < 10) {
            savedSalary = savedSalary * 1.05;
        } else if (savedWorkedYears >= 10) {
            savedSalary = savedSalary * 1.1;
        }

        System.out.println("Yearly salary is: " + savedSalary);
    }
}

public class EmployeeSignIn {
    public static void main(String[] args) {
        // Declare scanner
        Scanner input = new Scanner(System.in);
        // Create instance of the Employee class
        Employee Employee = new Employee(); 

        // Set employee ID
        System.out.println("Enter employee ID: ");
        int employeeId = input.nextInt();

        // Set employee salary
        System.out.println("Enter employee salary: ");
        double salary = input.nextDouble();

        // Set years employee worked
        System.out.println("Enter employee years worked: ");
        int workedYears = input.nextInt();

        // Set raise percent if any
        System.out.println("If the employee has reviced a raise enter the raise percent, else enter 0");
        double raisePercent = input.nextDouble();

        // Automatically initialize first employee 
        Employee.NewEmployee(employeeId, salary, workedYears, raisePercent);

        // Loop system indefinetly
        while (true) {
            // Spacer line
            System.out.println();

            // Print instructions
            System.out.println("Enter what action you want to do next."); 
            System.out.println("Type 1 for registering a new employee.");
            System.out.println("Type 2 for updating employee aniversary.");
            System.out.println("Type 3 for giving the employee a raise.");
            System.out.println("Type 4 for giving the employee a yearly bonus.");

            // Record respone to be used for switch
            int response = input.nextInt();

            // Switch for choosing which value to edit
            switch (response) {
                case 1:
                    // Edit employee
                    Employee.NewEmployee(employeeId, salary, workedYears, raisePercent);
                    break;
                    // Add to worked years
                case 2:
                    Employee.Anniversary();
                    break;
                    // Give raise
                case 3:
                    Employee.YouGotARaise();
                    break;
                    // Give bonus
                case 4:
                    Employee.YouGetABonus();
                    break;
            }
        }
    }
}