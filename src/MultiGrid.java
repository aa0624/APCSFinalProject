import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MultiGrid{
    private final int numGrids;
    private JFrame frame;
    private JPanel bottomtextpanel;
    private int row;
    public MultiGrid(int numGrids, int row, Boolean RandomColor, int letterAmt) throws FileNotFoundException {
        this.numGrids = numGrids;
        this.row=row;
        Grid[] gameGrids = new Grid[numGrids];
        JFrame frame = new JFrame("MultiWordle");
        frame.setLayout(new BorderLayout());
        for (int i = 0; i < numGrids; i++){
//            gameGrids[i] = new Grid(row, Main.generateWord());
            if(letterAmt == 3){
                gameGrids[i] = new Grid(row, Main.generateWordThree());
            } else if (letterAmt == 4){
                gameGrids[i] = new Grid(row, Main.generateWordFour());
            } else if (letterAmt == 5){
                gameGrids[i] = new Grid(row, Main.generateWordFive());
            } else if (letterAmt == 6){
                gameGrids[i] = new Grid(row, Main.generateWordSix());
            } else if (letterAmt == 7){
                gameGrids[i] = new Grid(row, Main.generateWordSeven());
            } else if (letterAmt == 8){
                gameGrids[i] = new Grid(row, Main.generateWordEight());
            } else {
                gameGrids[i] = new Grid(row, "Apple");
            }
            frame.add(gameGrids[i].getPanelNoFrame());
        }
        if (RandomColor == false) {
            AnswerChecker a = new AnswerChecker(row, gameGrids);
            frame.add(a.getBottomtextpanel(), BorderLayout.SOUTH);
            frame.setSize(500, 500);
            frame.setVisible(true);
        } else {
            WrongColor a = new WrongColor(row, gameGrids);
            frame.add(a.getBottomtextpanel(), BorderLayout.SOUTH);
            frame.setSize(500, 500);
            frame.setVisible(true);
        }
    }
}

