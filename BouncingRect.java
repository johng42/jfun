import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BouncingRect {
    int x;
    int y;
    Color color;
    int xDirection = 0;
    int yDirection = 0;

    final int SIZEX = 40;
    final int SIZEY = 20;

    /**
     * Initialize a new box with its center located at (startX, startY), filled
     * with startColor.
     */
    public BouncingRect(int startX, int startY, Color startColor) {
        x = startX;
        y = startY;
        color = startColor;
    }

    /** Draws the box at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the object
        surface.setColor(color);
        surface.fillRect(x - SIZEX/2, y - SIZEY/2, SIZEX, SIZEY);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawRect(x - SIZEX/2, y - SIZEY/2, SIZEX, SIZEY);

        // Move the center of the object each time we draw it
        x += xDirection;
        y += yDirection;

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((x - SIZEX/2 <= 0 && xDirection < 0) ||
                (x + SIZEX/2 >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((y - SIZEY/2 <= 0 && yDirection < 0) ||
                (y + SIZEY/2 >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
} 