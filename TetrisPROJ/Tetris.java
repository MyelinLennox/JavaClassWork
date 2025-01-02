import jcurses.system.InputChar;
import jcurses.system.Toolkit;


public class Tetris {
    static int[][] board = new int[22][10];
    static boolean screenUpdate = true;




    public static void main(String[] args) {
        board[0][0] = 1;
        board[0][5] = 1;
        board[9][8] = 1;
        board[8][8] = 1;

        while (true) {
            updateDisplay(board);

            try {
                gameTick();
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

               
    }

    public static void gameTick() {
        
        updateBlocksPos(board);
    }

    public static void updateBlocksPos(int[][] display) {
        screenUpdate = true;
        for (int i = display.length - 3; i >= 0; i--) {
            for (int j = 0; j < display[i].length; j++) {
                if (display[i][j] == 1 && display[i + 1][j] == 0) {
                    display[i][j] = 0;
                    display[i + 1][j] = 1;
                }
            }
        }
        screenUpdate = false;
    }

    public static void updateDisplay(int[][] display) {
        System.out.print("\033[H\033[2J");

        for (int i = 0 ; i < display.length ; i++) {
            System.out.println();

            for (int j = 0 ; j < display[i].length ; j++) {

                if (j == 0) {
                    if (i == 21 || i == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("\u2595");
                    }
                }

                switch (display[i][j]) {
                    case 0:
                        if (i == 0) {
                            System.out.print("\u2581\u2581");
                        } else if (i == 21) {
                            System.out.print("\u2594\u2594");
                        } else {
                            System.out.print("  ");
                        }
                        break;

                    case 1:
                        if (i == 0) {
                            System.out.print("\u2581\u2581");
                        } else if (i == 21) {
                            System.out.print("\u2594\u2594");
                        } else {
                            System.out.print("\u2591\u2591");
                        }
                        break;
                }

                if (j == 9 && i != 21 && i != 0) {
                    System.out.print("\u258F");
                }
                
            }

        }
        System.out.flush();
    }
}