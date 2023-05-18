import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class CustomColors extends Applet {
    private int red;
    private int green;
    private int blue;

    public CustomColors(int redvalue, int greenvalue, int bluevalue){
        red = redvalue;
        green = greenvalue;
        blue = bluevalue;
    }

    public void setRed(int newred){
        red = newred;
    }
    public void setGreen(int newgreen){
        green = newgreen;
    }
    public void setBlue(int newblue){
        blue = newblue;
    }

    public int getRed() {
        return red;
    }
    public int getGreen() {
        return green;
    }
    public int getBlue() {
        return blue;
    }

    public Color createColor(){
        Color colorcustom = new Color(red,green,blue);
        return colorcustom;
    }
}
