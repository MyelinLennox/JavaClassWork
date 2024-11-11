import java.util.Scanner;
import java.util.Random;

class MineSweeper {
    public static void main(String[] args) {
        Random random = new Random();
        int gridSize = 8;
        boolean[][] sweeperGrid = new int[gridSize][gridSize];
        
        for (int xGrid : gridSize) {
            for (int yGrid : gridSize) {
                sweeperGrid[xGrid][yGrid] = random.nextBoolean();
            }
        }
    }
}