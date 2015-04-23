import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BouncingTri {
    int x;
    int y;
    int xBottomLeft;
    int yBottomLeft;
    int length;
    Color color;
    int xDirection = 0;
    int yDirection = 0;

    int[] xPoints =new int[3];
    int[] yPoints =new int[3];
    /**
     * Initialize a new box with its center located at (startX, startY), filled
     * with startColor.
     */
    public BouncingTri(int startX, int startY, int BottomLeftx, int bottemLefty, int length, Color startColor) {
        x = startX;
        y = startY;
        xBottomLeft= BottomLeftx;
        yBottomLeft = bottemLefty;
        this.length = length;
        color = startColor;
        xPoints[0] = xBottomLeft;
        xPoints[1] = xBottomLeft + length;
        xPoints[2] = xBottomLeft+length/2;
        yPoints[0]= yBottomLeft;
        yPoints[1] = yBottomLeft;
        yPoints[2] = yBottomLeft+length;
     }

    /** Draws the box at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the object
        surface.setColor(color);
        surface.drawPolygon(xPoints,yPoints,3);
        surface.fillPolygon(xPoints,yPoints,3);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawPolygon(xPoints, yPoints, 3);

        // Move the bottom left of the object each time we draw it
        for (int i=0;i<3;i++) {
            xPoints[i] += xDirection;
            yPoints[i] += yDirection;
        }

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((xPoints[0]  <= 0 && xDirection < 0) ||
                (xPoints[1]  >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((yPoints[0]  <= 0 && yDirection < 0) ||
                (yPoints[1] +length >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
} 