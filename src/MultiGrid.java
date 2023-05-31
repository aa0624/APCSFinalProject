import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
//helper
public class MultiGrid{
    private final int numGrids;
    private JFrame frame;
    private int row;
    public MultiGrid(int numGrids, Boolean RandomColor, int letterAmt) throws FileNotFoundException {
        this.numGrids = numGrids;
        row = (letterAmt) + numGrids;
        Grid[] gameGrids = new Grid[numGrids];
        JFrame frame = new JFrame("MultiWordle");
        JPanel panel = new JPanel();
        frame.setLayout(new BorderLayout());
        for (int i = 0; i < numGrids; i++){
//            gameGrids[i] = new Grid(row, Main.generateWord());
            if(letterAmt == 3){
                gameGrids[i] = new Grid(row, Main.generateWordThree());
            } else if (letterAmt == 4){
                gameGrids[i] = new Grid(row, Main.generateWordFour());
            } else if (letterAmt == 5){
                gameGrids[i] = new Grid(row, Main.generateWordFive());
//                gameGrids[i] = new Grid(row, "APPLE");
            } else if (letterAmt == 6){
                gameGrids[i] = new Grid(row, Main.generateWordSix());
            } else if (letterAmt == 7){
                gameGrids[i] = new Grid(row, Main.generateWordSeven());
            } else if (letterAmt == 8){
                gameGrids[i] = new Grid(row, Main.generateWordEight());
            }
            panel.add(gameGrids[i].getPanelNoFrame());
        }
        frame.add(panel);
        if (RandomColor == false) {
            AnswerChecker a = new AnswerChecker(row, gameGrids, this);
            frame.add(a.getBottomtextpanel(), BorderLayout.SOUTH);
            frame.pack();
            frame.setVisible(true);
        } else {
            WrongColor a = new WrongColor(row, gameGrids, this);
            frame.add(a.getBottomtextpanel(), BorderLayout.SOUTH);
            frame.setSize(500, 500);
            frame.setVisible(true);
        }
    }
    public void setFrame() {
        this.frame=frame;
    }
    public Frame getFrame() {
        return frame;
    }

    public void closeFrame(){
        frame.dispose();
    }
}

