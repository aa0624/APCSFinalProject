import java.awt.*;

public class WrongColor extends AnswerChecker{
    public WrongColor(int row, Grid[] gameGrids){
        super(row, gameGrids);
        Color color1 = new Color(108, 169, 101);
        Color color2 = new Color(200, 182, 83);
        Color color3 = new Color(120, 124, 127);
        int random = (int) (Math.random() * 3 + 1);
        int random2 = (int) (Math.random() * 3 + 1);
        int random3 = (int) (Math.random() * 3 + 1);
        while (random2 == random){
            random2 = (int) (Math.random() * 3 + 1);
        }
        while (random3 == random || random3 == random2){
            random3 = (int) (Math.random() * 3 + 1);
        }

        if (random == 1){
            setCustomGreen(color1);
        } else if (random == 2){
            setCustomGreen(color2);
        } else {
            setCustomGreen(color3);
        } if (random2 == 1){
            setCustomYellow(color1);
        } else if (random2 == 2){
            setCustomYellow(color2);
        } else {
            setCustomYellow(color3);
        } if (random3 == 1){
            setCustomGrey(color1);
        } else if (random3 == 2){
            setCustomGrey(color2);
        } else {
            setCustomGrey(color3);
        }
    }
}
