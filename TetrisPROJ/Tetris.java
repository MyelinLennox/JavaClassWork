import java.util.Random;
import java.util.Scanner;


public class Tetris {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    static boolean screenUpdate = true;
    static boolean isPlaying = false;
    static boolean isBlockFalling = false;
    static int score = 0;

    static int[][] board = new int[22][10];
    static int[][][] Tetrominos = {
        {
            {2, 2, 2, 2}
        },
        {
            {2, 0, 0},
            {2, 2, 2}
        },
        {
            {0, 0, 2},
            {2, 2, 2}
        },
        {
            {2, 2},
            {2, 2}
        },
        {
            {2, 2, 0},
            {0, 2, 2}
        },
        {
            {0, 2, 2},
            {2, 2, 0}
        },
        {
            {0, 2, 0},
            {2, 2, 2}
        }
    };

    static boolean debug = true;

    public static void main(String[] args) {
        if (debug) {
            isPlaying = true;
        } else {
            startGame();
        }

        while (isPlaying) {
            
            if (!isBlockFalling) {
                checkloss();
                placeTetromino(board, rand.nextInt(7));
            }

            updateDisplay(board);

            try {
                updateBlocksPos(board);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (debug) {
            System.out.println();
            System.out.println("loss");
        } else {
            youLose();        
        }
    }

    public static void checkloss() {
        for (int i = 0; i < board[0].length; i++) {
            if (board[1][i] == 1) {
                isPlaying = false;
            }
        }
    }

    public static void startGame() {
        boolean tick = true;

        Thread inputThread = new Thread(() -> {
            while (true) {
                if (input.nextLine().isEmpty()) {
                    isPlaying = true;
                    break;
                }
            }
        });

        inputThread.start();

        while (!isPlaying) {
            try {
                System.out.println("\033[H\033[2J");
                System.out.flush();

                System.out.println();                                                     
                System.out.println();
                System.out.println();                                                     
                System.out.println();
                System.out.println();

                System.out.println("██     ██ ███████ ██       ██████  ██████  ███    ███ ███████     ████████  ██████      ");
                System.out.println("██     ██ ██      ██      ██      ██    ██ ████  ████ ██             ██    ██    ██     ");
                System.out.println("██  █  ██ █████   ██      ██      ██    ██ ██ ████ ██ █████          ██    ██    ██     ");
                System.out.println("██ ███ ██ ██      ██      ██      ██    ██ ██  ██  ██ ██             ██    ██    ██     ");
                System.out.println(" ███ ███  ███████ ███████  ██████  ██████  ██      ██ ███████        ██     ██████      ");
                System.out.println();                                                     
                System.out.println();
                System.out.println("                  ████████ ███████ ████████ ██████  ██ ███████   ");
                System.out.println("                     ██    ██         ██    ██   ██ ██ ██      ");
                System.out.println("                     ██    █████      ██    ██████  ██ ███████  ");
                System.out.println("                     ██    ██         ██    ██   ██ ██      ██ ");
                System.out.println("                     ██    ███████    ██    ██   ██ ██ ███████  ");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();

                if (tick) {
                    System.out.println("            ____                           ____   _                _   ");
                    System.out.println("           |  _ ⧵  _ __  ___  ___  ___    / ___| | |_  __ _  _ __ | |_ ");
                    System.out.println("           | |_) || '__|/ _ ⧵/ __|/ __|   ⧵___ ⧵ | __|/ _` || '__|| __|");
                    System.out.println("           |  __/ | |  |  __/⧵__ ⧵⧵__ ⧵    ___) || |_| (_| || |   | |_ ");
                    System.out.println("           |_|    |_|   ⧵___||___/|___/   |____/  ⧵__|⧵__,_||_|    ⧵__|");
                } else {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }

                tick = !tick;

                Thread.sleep(1600);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        try {
            inputThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }   

    public static void youLose() {
        System.out.println("\033[H\033[2J");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("██    ██  ██████  ██    ██     ██       ██████  ███████ ███████ ");
        System.out.println(" ██  ██  ██    ██ ██    ██     ██      ██    ██ ██      ██     ");
        System.out.println("  ████   ██    ██ ██    ██     ██      ██    ██ ███████ █████   ");
        System.out.println("   ██    ██    ██ ██    ██     ██      ██    ██      ██ ██     ");
        System.out.println("   ██     ██████   ██████      ███████  ██████  ███████ ███████  ");
        System.out.println();
        System.out.println();
        System.out.println("score: " + score);
        System.out.println();
        System.out.println();
        System.out.println("  ____   _                    _                  _        ___ ");
        System.out.println(" |  _ ⧵ | |  __ _  _   _     / ⧵    __ _   __ _ (_) _ __ |__ ⧵");
        System.out.println(" | |_) || | / _` || | | |   / _ ⧵  / _` | / _` || || '_ ⧵  / /");
        System.out.println(" |  __/ | || (_| || |_| |  / ___ ⧵| (_| || (_| || || | | ||_| ");
        System.out.println(" |_|    |_| ⧵__,_| ⧵__, | /_/   ⧵_⧵⧵__, | ⧵__,_||_||_| |_|(_) ");
        System.out.println("                    |___/           |___/                      ");
        System.out.println();
        System.out.println();
        System.out.println();

        if (input.nextLine().isEmpty()) {

        }
    }

    // update blocks position every game tick
    public static void updateBlocksPos(int[][] display) {
        
        // make sure screen is updating for block movement
        screenUpdate = true;

        // for each row in the display minus the last row
        for (int i = display.length - 2; i >= 0; i--) {

            for (int j = 0; j < display[i].length; j++) {
                if ( display[i][j] == 2 && !(i + 2 < display.length && display[i + 1][j] == 0)) { 
                    isBlockFalling = false;
                    break;
                }
            }

            if (isBlockFalling) {
                //for each positon in the row
                for (int j = 0; j < display[i].length; j++) {
                    // if the block is not at the bottom of the board and the block below it is empty
                    if (display[i][j] == 2 && i + 2 < display.length && display[i + 1][j] == 0) {
                        display[i][j] = 0;
                        display[i + 1][j] = 2;
                    }
                
                }
            }
        }
        
        // for each row in the display minus the last row
        if (!isBlockFalling) {
            for (int i = display.length - 2; i >= 0; i--) {
                //for each positon in the row
                for (int j = 0; j < display[i].length; j++) {
                    // if a moving block is on the board and the block is not 0
                    if (display[i][j] == 2) {
                        // set stationary
                        display[i][j] = 1;
                    }
                }
            }
        }
        screenUpdate = false;
    }

    public static void placeTetromino(int[][] display, int tetromino) {
        isBlockFalling = true;
        for (int i = 0; i < display.length ; i++) {
            if (i >= Tetrominos[tetromino].length) {
                break;
            } else {
                for (int j = 0; j < Tetrominos[tetromino][i].length ; j++) {
                    display[i][(j+5)-(int)Math.ceil((double)Tetrominos[tetromino][0].length/2)] = Tetrominos[tetromino][i][j];
                }
            }
        }
    }

    public static void updateDisplay(int[][] display) {
        System.out.print("\033[H\033[2J");

        if (debug) {
            System.out.println();
            System.out.println();
            System.out.println();
        }

        for (int i = 0 ; i < display.length ; i++) {
            System.out.println();

            for (int j = 0 ; j < display[i].length ; j++) {
                if (debug) {
                    System.out.print("  " + display[i][j]);
                } else {
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
                        case 2:
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
        System.out.flush();
    }
}