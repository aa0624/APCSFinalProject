import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MultiGrid{
    private final int numGrids;
    private JFrame frame;
    private JPanel bottomtextpanel;
    private int row;
    public MultiGrid(int numGrids, int row) throws FileNotFoundException {
        this.numGrids = numGrids;
        this.row=row;
        Grid[] gameGrids = new Grid[numGrids];
        JFrame frame = new JFrame("MultiWordle");
        frame.setLayout(new BorderLayout());
        for (int i = 0; i < numGrids; i++){
//            gameGrids[i] = new Grid(row, Main.generateWord());
            gameGrids[i] = new Grid(row, "APPLE");
            frame.add(gameGrids[i].getPanelNoFrame());
        }
        AnswerChecker a=new AnswerChecker(row, gameGrids);
        frame.add(a.getBottomtextpanel(), BorderLayout.SOUTH);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}

