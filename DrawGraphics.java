import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawGraphics {
    List<BouncingBox> bbList = new ArrayList<BouncingBox>();
    List<BouncingRect> brList = new ArrayList<BouncingRect>();
    List<BouncingCircle> bcList = new ArrayList<BouncingCircle>();
    List<BouncingTri> bTriList = new ArrayList<BouncingTri>();
    /** Initializes this class for drawing. */

    public DrawGraphics() {
        Random r = new Random();
        r.setSeed(75961);
        for (int i=0;i<3;i++){
            int x = 0;
            int y=0;
            BouncingTri bTri = new BouncingTri(i+44,i+77,i+44,i+77,30, Color.getHSBColor((float)(i*10+22), (float)(i*30+44), (float)(i*50+55)));

            BouncingBox b = new BouncingBox(i*10,i*12,Color.getHSBColor((float)(i*10), (float)(i*30), (float)(i*50)));
            //BouncingRect br = new BouncingRect(i*20,i*30, Color.getHSBColor((float)(i*20+100), (float)(i*5), (float)(i*60)));
            BouncingCircle bc = new BouncingCircle(i+40,5*i+60, 40, Color.cyan);
            while(x ==0 )x=r.nextInt(10)-5;
            while (y==0) y=r.nextInt(10)-5;
            b.setMovementVector(x,y);
            x=0;y=0;
//            while(x ==0 )x=r.nextInt(10)-5;
//            while (y==0) y=r.nextInt(10)-5;
//            br.setMovementVector(x,y);
            while(x ==0 )x=r.nextInt(10)-5;
            while (y==0) y=r.nextInt(10)-5;
            bc.setMovementVector(x,y);
            bbList.add(b);
            //brList.add(br);
            bcList.add(bc);

            x=0;y=0;
            while(x==0) x=r.nextInt(10)-5;
            while (y==0) y=r.nextInt(10)-5;
            bTri.setMovementVector(x,y);
            bTriList.add(bTri);
        }
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawOval(100, 210, 55, 22);
        surface.drawArc(45, 45, 3, 82, 10, 90);
        //surface.drawString("♠",200,55);

        for(BouncingBox b : bbList){
            b.draw(surface);
        }
//        for(BouncingRect b : brList){
//            b.draw(surface);
//        }

        for(BouncingCircle b : bcList){
            b.draw(surface);
        }

        for (BouncingTri b : bTriList){
            b.draw(surface);
        }
    }

    public void drawSpade(Graphics surface){
        surface.drawString("♠",200,55);
    }

} 