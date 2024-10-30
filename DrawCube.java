//Working coe
/*
import java.util.Scanner;

public class DrawCube {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter X position (1-10): ");
        int xPos = input.nextInt();


        System.out.println("Enter Y position (1-10): ");
        int yPos = input.nextInt();

        System.out.println("Enter square length: ");
        int length = input.nextInt();

        length = Math.min(length, 10-xPos);
        length = Math.min(length, yPos);

        drawLine(xPos, yPos, xPos+length, yPos);
        drawLine(xPos, yPos, xPos, yPos-length);
        drawLine(xPos, yPos-length, xPos+length, yPos-length);
        drawLine(xPos+length, yPos, xPos+length, yPos-length);

        System.out.println("Side length : " + length);
        System.out.println("Area: " + length*length);
    }

    public static void drawLine(int x1, int y1, int x2, int y2) {}
}
*/







// TOTALLY BROKEN RENDERING ENGINE


import java.awt.*;
import java.awt.geom.*;
import java.util.Scanner;
import javax.swing.*;

public class DrawCube {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int scaleMultiplier = 50;

        System.out.println("Enter X position (1-10): ");
        // Adjust X position
        int xPos = (input.nextInt() * scaleMultiplier) - scaleMultiplier;

        System.out.println("Enter Y position (1-10): ");
        // Adjust Y position
        int yPos = (input.nextInt() * scaleMultiplier) - scaleMultiplier;

        System.out.println("Enter square length: ");
        int initialLength = input.nextInt() * scaleMultiplier;

        // Calculate length before creating the panel
        int length = Math.min(initialLength, (10 * scaleMultiplier) - xPos);
        length = Math.min(length, yPos);


// **  It would be easier if you did the input and limiting first, then scaled everything



        // Frame
        int windowW = 517;
        int windowH = 539;      // ** only on letter different ....asking for trouble
        JFrame frame = new JFrame();
        frame.setSize(windowW, windowH);
        frame.setTitle("Cube Render");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CustomPanel panel = new CustomPanel(xPos, yPos, length);   // ** I don't understand this.
        frame.add(panel);
        frame.setVisible(true);
    }
}

// Custom JPanel class
class CustomPanel extends JPanel {
    private final int xPos;
    private final int yPos;
    private final int length;

    // Constructor to initialize positions and lengths
    public CustomPanel(int xPos, int yPos, int length) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.length = length;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw grid
        drawGrid(g2d);

        // Use instance variables for drawing
        drawLine(g2d, xPos, yPos, xPos + length, yPos);
        drawLine(g2d, xPos, yPos, xPos, yPos - length);
        drawLine(g2d, xPos, yPos - length, xPos + length, yPos - length);
        drawLine(g2d, xPos + length, yPos, xPos + length, yPos - length);
    }

    private void drawGrid(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);
        int width = getWidth();
        int height = getHeight();
        // Draw vertical grid lines
        for (int x = 0; x <= width; x += 50) {
            g2d.drawLine(x, 0, x, height);
        }
        // Draw horizontal grid lines
        for (int y = 0; y <= height; y += 50) {
            g2d.drawLine(0, y, width, y);
        }
    }

    public void drawLine(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(Color.BLACK);
        g2d.draw(line);
    }
}
