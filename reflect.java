/**
 * Created by johnguin on 4/22/2015.
 */

import java.lang.reflect.*;



public class reflect {

    public static void main(String[] args) {
        Class reflectClass = DrawGraphics.class;
        String classname = reflectClass.getName();
        //System.out.println(classname + "\n");
        Class[] methods = reflectClass.getDeclaredMethods();
        for (i=0; i=<methods.length; i++; ){
            System.out.println(methods[i]);
        }
    }

}
