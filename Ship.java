import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Ship {
    int x;
    int y;
    int length;
    int height;
    Color color;
    int xDirection = 0;
    int yDirection = 0;
    int score;  //need to move this?

//    int[] xPoints =new int[3];
//    int[] yPoints =new int[3];

    public Ship(int startX, int startY, int length, int height, Color startColor){
        x = startX;
        y = startY;

        this.length = length;
        this.height = height;
        color = startColor;
        score = 0;
    }

    public void draw(Graphics surface) {
        // Draw the object
        surface.setColor(color);
        //surface.drawPolygon(xPoints,yPoints,3);
        //surface.fillPolygon(xPoints,yPoints,3);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        //surface.drawPolygon(xPoints, yPoints, 3);



        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((x  <= 0 && xDirection < 0) ||
                (x  >= SimpleDraw.WIDTH && xDirection > 0)) {
            //xDirection = -xDirection;
            score--;

        }
        if ((y  <= 0 && yDirection < 0) ||
                (y +length >= SimpleDraw.HEIGHT && yDirection > 0)) {
            score--;
        }

        ((Graphics2D) surface).drawString(Integer.toString(score),10,10);
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
}
