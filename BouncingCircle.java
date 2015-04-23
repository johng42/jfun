import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BouncingCircle {
    int centerX;
    int centerY;
    int radius;
    Color color;
    int xDirection = 0;
    int yDirection = 0;


    /**
     * Initialize a new box with its center located at (startX, startY), filled
     * with startColor.
     */
    public BouncingCircle(int centerX, int centerY, int radius, Color startColor) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        color = startColor;
    }

    /** Draws the box at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the object
        surface.setColor(color);
        surface.drawOval(centerX,centerY,radius,radius);
        surface.fillOval(centerX , centerY,radius, radius);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(5.0f));
        surface.drawOval(centerX,centerY,radius,radius);

        // Move the center of the object each time we draw it
        centerX += xDirection;
        centerY += yDirection;

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((centerX - radius <= 0 && xDirection < 0) ||
                (centerX + radius >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((centerY - radius <= 0 && yDirection < 0) ||
                (centerY + radius >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
} 