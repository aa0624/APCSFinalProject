import javax.swing.*;
import java.awt.*;

public class Grid {
    private final String answer;
    private char[][] spaces;

    private Color[][] colors;
    private JLabel[][] letters;

    private final JPanel frame;
    private JPanel allWordGrid;
    private boolean win;
    private final JPanel[] wordGrid;
    private final int row;
    private final int col;
    private String finalText;

    public Grid(int row, String answer) {
        this.row = row;
        this.col = answer.length();
        this.answer = answer;
        this.finalText="you lose";
        spaces = new char[row][col];
        colors = new Color[row][col];
        letters = new JLabel[row][col];
        win=false;

        frame = new JPanel();
        frame.setLayout(new BorderLayout());


        allWordGrid = new JPanel();
        allWordGrid.setLayout(new BoxLayout(allWordGrid, BoxLayout.Y_AXIS));

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
                var placeHolder = letters[i][j];
                wordGrid[i].add(placeHolder);
            }
            allWordGrid.add(wordGrid[i]);
        }

        frame.add(allWordGrid, BorderLayout.NORTH);

        // action button function specifically for the enter button
    }

    public char[][] getSpaces() {
        return spaces;
    }

    public Color[][] getColors() {
        return colors;
    }

    public JLabel[][] getLetters() {
        return letters;
    }

    public void setSpaces(char[][] spaces) {
        this.spaces = spaces;
    }

    public void setColors(Color[][] colors) {
        this.colors = colors;
    }

    public void setLetters(JLabel[][] letters) {
        this.letters = letters;
    }

    public void setFinalText(String finalText) {
        this.finalText = finalText;
    }

    public String getFinalText() {
        return finalText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    public boolean getWin() {
        return win;
    }


    public JPanel getPanelNoFrame(){
        return frame;
    }

    public void setAllWordGrid(JPanel allWordGrid) {
        this.allWordGrid = allWordGrid;
    }

    public JPanel getAllWordGrid() {
        return allWordGrid;
    }

    public int getCol() {
        return col;
    }
}
