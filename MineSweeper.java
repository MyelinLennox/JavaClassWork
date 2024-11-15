// Myelin Lennox, Minesweeper game

// Define random and scanner
import java.util.Random;
import java.util.Scanner;

// Main class
class MineSweeper {
    // Main class used for initialization
    public static void main(String[] args) {
        // Define scanenr and grid size
        Scanner input = new Scanner(System.in);
        int gridSize;

        // Ask for the grid size then clear the input
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Enter how big you want the grid to be: ");

        gridSize = input.nextInt();
        input.nextLine();

        // Create two booleans for keeping track of discovered spot and one for containing bombs also generate the grid
        boolean[][] sweeperGrid = createGrid(gridSize);
        boolean[][] revealedGrid = new boolean[gridSize][gridSize];

        // Initiated the game loop
        gameLoop(sweeperGrid, revealedGrid, gridSize);
    }

    // Game loop
    public static void gameLoop(boolean[][] grid, boolean[][] revealedGrid, int gridSize) {
        // Define scanner, input for searched location, and the converted location to int
        Scanner input = new Scanner(System.in);
        String[] stringLocation;
        int[] coordinatesLocation = new int[2];

        // Loop forever because win/fail states will be handled when the grid is printed
        while (true) {
            // Request grid location
            System.out.println("\nEnter the coordinates of your pick (E.g. '1,2'):");
            try {
                // Get a string input then split them between the comma then assign each half to one side of a 1d array with 2 indexs
                stringLocation = input.nextLine().split(",");
                int x = Integer.parseInt(stringLocation[0].trim());
                int y = Integer.parseInt(stringLocation[1].trim());

                // If the grid size is inbetween one through the max range, then ofset by one to make math easier
                if (x >= 1 && x <= gridSize && y >= 1 && y <= gridSize) {
                    coordinatesLocation[0] = x - 1;
                    coordinatesLocation[1] = y - 1;
                    break;
                } else {
                    System.out.println("Coordinates must be between 1 and " + gridSize + ".");
                }
                // "catch" is used to give specified feedback if the numbers are out of range also using "try" is easier for looping
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter valid integer coordinates (E.g. '1,2')");
            }
        }

        // Mark the spot that we input into the revealedGrid then pritn the visual
        revealedGrid[coordinatesLocation[1]][coordinatesLocation[0]] = true;
        printGrid(gridSize, grid, revealedGrid, coordinatesLocation);
    }

    // Generating grid
    public static boolean[][] createGrid(int gridSize) {
        // Define the boolean for the grid and the random value object
        boolean[][] sweeperGrid = new boolean[gridSize][gridSize];
        Random random = new Random();

        // For each x and y in the grid make a 20% chance to have a bomb
        for (int yGrid = 0; yGrid < gridSize; yGrid++) {
            for (int xGrid = 0; xGrid < gridSize; xGrid++) {
                sweeperGrid[yGrid][xGrid] = random.nextInt(100) <= 20;
            }
        }
        return sweeperGrid;
    }

    // Printing the grid
    public static void printGrid(int gridSize, boolean[][] sweeperGrid, boolean[][] revealedGrid, int[] coordinatesLocation) {
        // Define length of characters on the axis to ofset them for visual appearence
        int characterLength = String.valueOf(gridSize).length();
        // Keep track fi the player hit a bomb or not
        boolean isAlive = true;

        // Erase all other console output to keep it clean and less confusing
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Use string manipulation to make spaces for the x axis numbers 
        for (int j = 0; j <= characterLength + 1; j++) {
            System.out.print(" ");
        }
        // Use string manipulation to form a string manipulation (this one hurt alot)
        for (int i = 0; i < gridSize; i++) {
            System.out.printf("%-" + (characterLength + 1) + "d", i + 1);
        }

        System.out.println();

        // Make dividers to seperate numbers and actual grid
        for (int j = 0; j <= characterLength + 1; j++) {
            System.out.print(" ");
        }
        for (int i = 0; i < gridSize; i++) {
            System.out.printf("%-" + (characterLength + 1) + "s", "_");
        }

        System.out.println();

        for (int yGrid = 0; yGrid < gridSize; yGrid++) {
            // More strign manipulation for the y axis side numbers
            System.out.printf("%-" + (characterLength) + "d", yGrid + 1);
            System.out.print(" |");

            // If the current spot on the grid matches the one we input
            for (int xGrid = 0; xGrid < gridSize; xGrid++) {
                if (revealedGrid[yGrid][xGrid]) {
                    // Show an X if a bomb was hit otherwise switch to the function to get the number of surronding bombs
                    if (sweeperGrid[yGrid][xGrid]) {
                        System.out.print("X");
                        isAlive = false;
                    } else {
                        int bombCount = countSurroundingBombs(sweeperGrid, yGrid, xGrid);
                        System.out.print(bombCount);
                    }
                } else { 
                    // Hide all unrevealed spots 
                    System.out.print("-");
                }
                // Spacer fit to follwo appearence of x axis numbers
                System.out.printf("%-" + (characterLength) + "s", " ");
            }
            System.out.println();
        }

        // Continute loop if no bombs were hit otherwise show loss screen
        if (isAlive) {
            gameLoop(sweeperGrid, revealedGrid, gridSize);
        } else {
            lose();
        }
    }

    // Find surrounding bombs
    public static int countSurroundingBombs(boolean[][] grid, int y, int x) {
        // Define bomb count and the size of the grid
        int bombCount = 0;
        // Use .length to get teh size of one dimension of the array (we onl;y need one because its a square)
        int gridSize = grid[0].length;

        // Loop through every square forward and back one this returns 9 squares
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Define nieghboring cell
                int newY = y + i;
                int newX = x + j;

                // if the cell contains a bimb icnrease the bomb count
                if (newY >= 0 && newY < gridSize && newX >= 0 && newX < gridSize && !(i == 0 && j == 0)) {
                    if (grid[newY][newX]) {
                        bombCount++;
                    }
                }
            }
        }
        return bombCount;
    }


    // ASCII art generated by https://patorjk.com/software/taag/

    // WIn secinario
    public static void win() {
        
        System.out.println("oooooo   oooo   .oooooo.   ooooo     ooo      oooooo   oooooo     oooo ooooo ooooo      ooo");
        System.out.println(" `888.   .8'   d8P'  `Y8b  `888'     `8'       `888.    `888.     .8'  `888' `888b.     `8'");
        System.out.println("  `888. .8'   888      888  888       8         `888.   .8888.   .8'    888   8 `88b.    8"); 
        System.out.println("   `888.8'    888      888  888       8          `888  .8'`888. .8'     888   8   `88b.  8"); 
        System.out.println("    `888'     888      888  888       8           `888.8'  `888.8'      888   8     `88b.8");   
        System.out.println("     888      `88b    d88'  `88.    .8'            `888'    `888'       888   8       `888");   
        System.out.println("    o888o      `Y8bood8P'     `YbodP'               `8'      `8'       o888o o8o        `8");
        System.out.println();
    }
    // Lose scenario
    public static void lose() {
        System.out.println();
        System.out.println("oooooo   oooo   .oooooo.   ooooo     ooo      ooooo          .oooooo.    .oooooo..o oooooooooooo");
        System.out.println(" `888.   .8'   d8P'  `Y8b  `888'     `8'      `888'         d8P'  `Y8b  d8P'    `Y8 `888'     `8");
        System.out.println("  `888. .8'   888      888  888       8        888         888      888 Y88bo.       888        ");
        System.out.println("   `888.8'    888      888  888       8        888         888      888  `'Y8888o.   888oooo8   ");
        System.out.println("    `888'     888      888  888       8        888         888      888      `'Y88b  888    '   ");
        System.out.println("     888      `88b    d88'  `88.    .8'        888       o `88b    d88' oo     .d8P  888       o");
        System.out.println("    o888o      `Y8bood8P'     `YbodP'         o888ooooood8  `Y8bood8P'  8''88888P'  o888ooooood8");
        System.out.println();

    }
}

