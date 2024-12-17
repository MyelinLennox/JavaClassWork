
public class Tetris {
    static int[][] board = new int[22][10];
    static boolean isPlaying = false;

    public static void main(String[] args) {
        isPlaying = true;

        board[0][0] = 1;
        board[0][5] = 1;
        board[9][8] = 1;
            
        try {
            Thread.sleep(1000);
            board[0][0] = 1;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (isPlaying) {
            
            try {
                Thread.sleep(125);
                updateDisplay(board);
                updateBlocksPos(board);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void updateBlocksPos(int[][] display) {
        for (int i = display.length - 3; i >= 0; i--) {
            for (int j = 0; j < display[i].length; j++) {
                if (display[i][j] == 1 && display[i + 1][j] == 0) {
                    display[i][j] = 0;
                    display[i + 1][j] = 1;
                }
            }
        }
    }

    public static void updateDisplay(int[][] display) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

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
    }
}