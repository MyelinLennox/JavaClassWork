
public class KeyLogger {
    // Load the DLL
    static {
        System.loadLibrary("ConsoleKeyLogger");
    }

    // Declare the native method
    public native char getKeyPressed();

    public static void main(String[] args) {
        KeyLogger keyLogger = new KeyLogger();

        // Loop to keep checking for key presses
        while (true) {
            char key = keyLogger.getKeyPressed();
            if (key != 0) {
                System.out.println(key);
                if (key == 32) {
                    System.out.println("space");
                }
            }
            try {
                Thread.sleep(100); // Delay for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
