import java.util.Random;
import java.util.Scanner;


public class Tetris {
    static {
        System.loadLibrary("ConsoleKeyLogger");
    }

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

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

    boolean debug = false;

    public static void main(String[] args) {
        new Tetris().startGame();
    }

    public void startGame() {
        score = 0;
        board = new int[22][10];
        isBlockFalling = false;

        boolean tick = true;
        boolean breakLoop = false;

        while (!debug) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            renderDisplay(10, j+10, "Console Tetris");

            renderDisplay(5, j+10, "Press Start");

            tick = !tick;

            for (int i = 0 ; i < 100 ; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                if (i >= 25 && (getKeys() == 13)) {
                    breakLoop = true;
                    break;
                }
                
            }

            if (breakLoop) {
                break;
            }
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();
        
        System.out.println();
        System.out.println("██████╗ ");
        System.out.println("╚════██╗");
        System.out.println(" █████╔╝");
        System.out.println(" ╚═══██╗");
        System.out.println("██████╔╝");
        System.out.println("╚═════╝ ");
        System.out.println();            

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println();
        System.out.println("██████╗ ");
        System.out.println("╚════██╗");
        System.out.println(" █████╔╝");
        System.out.println("██╔═══╝ ");
        System.out.println("███████╗");
        System.out.println("╚══════╝");
        System.out.println();            

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println();
        System.out.println(" ██╗");
        System.out.println("███║");
        System.out.println("╚██║");
        System.out.println(" ██║");
        System.out.println(" ██║");
        System.out.println(" ╚═╝");
        System.out.println();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }   

                                                                                                 
                                                                                         
                                                                                         
        System.out.println("˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖");
        System.out.println("˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖");
        System.out.println("˖˖˖˖˖┌────Next────┐˖˖˖╔══════════════════════╗˖˖˖˖˖");
        System.out.println("˖˖˖˖˖├────────────┤˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│            │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│            │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│            │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖└────────────┘˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖┌────────────┐˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│ Score: 000 │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│            │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│ Level: 000 │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖└────────────┘˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖┌────────────┐˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│LEADERBOARD:│˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖├────────────┤˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│₁           │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│₂           │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│₃           │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│₄           │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖│₅           │˖˖˖║                      ║˖˖˖˖˖");
        System.out.println("˖˖˖˖˖└────────────┘˖˖˖╚══════════════════════╝˖˖˖˖˖");
        System.out.println("˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖");
        System.out.println("˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖˖");           

        playLoop();  
    }   

    public void playLoop() {
        while (true) {
            int gameTicks = 0;

            if (!isBlockFalling) {
                if (checkloss()) {
                    break;
                }
                placeTetromino(board, rand.nextInt(7));
            }
            //computeDisplay(board);

            if (gameTicks % 20 == 0) {
                updateMovingBlocks(board);
                updateFallingBlocks(board);
                checkBlockState(board);
            } else {
                updateMovingBlocks(board);
                checkBlockState(board);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        youLose();
    }

    public boolean checkloss() {
        for (int i = 0; i < board[0].length; i++) {
            if (board[1][i] == 1) {
                return true;
            }
        }
        return false;
    }

    public void youLose() {      
        if (!debug) {
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
 
            
        } else {
            System.out.println();
            System.out.println("loss");
        }

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        while (true) { 
            if (getKeys() == 13) {
                startGame();
                break;
            }
        }
        
        
    }

    public char getKeys() {
        char key = new KeyLogger().getKeyPressed();
        if (key != 0) {
            if (debug) {
                System.out.println(key);
            }
            return key;
        } else {
            return ' ';
        }
    }
    
    // update blocks position every game tick
    public void updateFallingBlocks(int[][] display) {

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
                        renderDisplay(i, j+10, "  ");
                        renderDisplay(i+1, j+10, "22");
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
                        renderDisplay(i+1, j+10, "11");
                    }
                }
            }
        }
    }
    
    public void updateMovingBlocks(int [][] display) {
        // for each row in the display minus the last row
        for (int i = display.length - 2; i >= 0; i--) {

            
            for (int j = 0; j < display[i].length; j++) {
                if (display[i][j] == 2 && display[i][j] > 0 ) {
                    if (display[i][j++] == 1) { 
                        break;
                    }
                } else if (display[i][j] == 2 && display[i][j] < display[i].length) {
                    if (display[i][j--] == 1) { 
                        break;
                    }
                } else if (display[i][j] == 2) {
                    if (display[i][j++] == 1 || display[i][j--] == 1) { 
                        break;
                    }
                }
                
                
            }
            

            if (isBlockFalling) {
                //for each positon in the row
                for (int j = 0; j < display[i].length; j++) {
                    switch (getKeys()) {
                        case 'a' -> {
                            if (display[i][j] == 2 && j - 1 >= 0 && display[i][j - 1] == 0) {
                                display[i][j] = 0;
                                display[i][j - 1] = 2;
                            }
                        }
                        case 's' -> {
                            display[i][j] = 0;
                            display[i + 1][j] = 2;
                        }
                        case 'd' -> {
                            if (display[i][j] == 2 && j + 1 < display[i].length && display[i][j + 1] == 0) {
                                display[i][j] = 0;
                                display[i][j + 1] = 2;
                            }
                        }
                    }
                }
            }
        }
    }

    public void checkBlockState(int[][] display) {
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
    }

    public void placeTetromino(int[][] display, int tetromino) {
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

    public void computeDisplay(int[][] display) {
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

    public void renderDisplay(int i, int j, String chars) {
        System.out.print("\033[" + (i + 1) + ";" + (j * 2 + 1) + "H");
        System.out.print(chars);
        System.out.flush();
    }
}
