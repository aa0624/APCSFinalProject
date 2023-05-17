import javax.swing.*;
import java.awt.*;

public class Grid {
    private final String answer;
    private final char[][] spaces;

    private final Color[][] colors;

    private final JFrame frame;

    private final JPanel allwordGrid;

    private final JPanel[] wordGrid;
    private final int row;
    private final int col;
    private int currentRow;

    private final JLabel[][] letters;


    public Grid(int row, String answer) {
        this.row = row;
        this.col = answer.length();
        this.answer = answer;
        spaces = new char[row][col];
        colors = new Color[row][col];
        letters = new JLabel[row][col];
        AnswerChecker a = new AnswerChecker(row, answer, spaces, colors, letters);


        // Creates Frame
        frame = new JFrame("Wordle");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        allwordGrid = new JPanel();
        allwordGrid.setLayout(new BoxLayout(allwordGrid, BoxLayout.Y_AXIS));

        //Creates panel for word 1 which will hold all the letters
        wordGrid = new JPanel[row];
        for (int i = 0; i < wordGrid.length; i++) {
            wordGrid[i] = new JPanel();
            wordGrid[i].setLayout(new BoxLayout(wordGrid[i], BoxLayout.X_AXIS));
        }

        //Creates the letter holders for word 1
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[0].length; j++) {
                letters[i][j] = new JLabel(" ");
            }
        }

        for (int i = 0; i < wordGrid.length; i++) {
            for (int j = 0; j < letters[0].length; j++) {
                var label = letters[i][j];
                wordGrid[i].add(label);
            }
            allwordGrid.add(wordGrid[i]);
        }

        frame.add(allwordGrid, BorderLayout.NORTH);
        frame.add(a.getBottomTextPanel());
        frame.pack();
        frame.setVisible(true);
        // action button function specifically for the enter button
    }
}