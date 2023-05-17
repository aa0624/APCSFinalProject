import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Grid {
    private final String answer;
    private final char[][] spaces;

    private final Color[][] colors;

    private final JFrame frame;

    private JPanel word1Grid;
    private JPanel word2Grid;
    private JPanel word3Grid;
    private JPanel word4Grid;
    private JPanel word5Grid;
    private JPanel word6Grid;
    private final JPanel bottomtextpanel;
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

        bottomtextpanel = new JPanel();
        bottomtextpanel.setLayout(new BorderLayout());
        frame.add(bottomtextpanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField("", 10);
        bottomtextpanel.add(answerField, BorderLayout.WEST);

        JButton enterButton = new JButton("Enter");
        bottomtextpanel.add(enterButton, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
        // action button function specifically for the enter button
        enterButton.addActionListener(e -> {
            if (answerField.getText().length() == answer.length()) {
                compareToAnswer(answer, answerField.getText().toUpperCase());
                answerField.setText(" ");
            }
        });
    }

    // compares word to answer and updates both 2d arrays with calls to other functions
    public void compareToAnswer(String answer, String guess) {
        int greencount = 0;
        Color[] listOfColors = new Color[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                answer = answer.substring(0, i) + " " + answer.substring(i + 1);
                listOfColors[i] = Color.GREEN;
                greencount++;
            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                answer = answer.substring(0, i) + " " + answer.substring(i + 1);
                listOfColors[i] = Color.YELLOW;
            } else {
                listOfColors[i] = Color.RED;
            }
        }
        if (greencount == answer.length()) {
            congratulate();
        }
        updateColorList(listOfColors);
        updateWordShown(guess);
        updateLetters(guess);
        currentRow++;
        frame.repaint();
    }

    private void congratulate() {

    }

    //takes a list of colors and adds it to the next row available in the 2d color array
    private void updateColorList(Color[] colorlist) {
        System.arraycopy(colorlist, 0, colors[currentRow], 0, colors[0].length);
    }

    //updates the letters graphic (I couldn't think of a better way to do this so if you do just change it bc this is ugly)
    private void updateLetters(String guess) {
        for (int i = 0; i < col; i++) {
            letters[currentRow][i].setText(String.valueOf(guess.charAt(i)));
            letters[currentRow][i].setForeground(colors[currentRow][i]);
        }
    }

    // updates the letters in the 2d Array
    private void updateWordShown(String guess) {
        for (int i = 0; i < spaces[0].length; i++) {
            spaces[currentRow][i] = guess.charAt(i);
        }
    }


    //    private Color[] guessWordColors(String answer, String guess) {
//        Color[] listOfColors = new Color[answer.length()];
//
//        if (guess.length() != answer.length() || answer.isEmpty()) {
//            return listOfColors;
//        }
//    for (int i = 0; i < answer.length(); i++) {
//        if (answer.charAt(i) == guess.charAt(i)) {
//            listOfColors[i] = Color.GREEN;
//        } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
//            answer = answer.substring(0, i) + " " + answer.substring(i+1);
//            listOfColors[i] = Color.YELLOW;
//        } else {
//            listOfColors[i] = Color.RED;
//        }
//    }
//
//        return listOfColors;
//}
    //moved the main function to here bc i couldnt find a reason why overriding it was a good idea
    private Color[] guessWordColors(String answer, String guess) {
        Color[] listOfColors = new Color[answer.length()];

        if (guess.length() != answer.length() || answer.isEmpty()) {
            return listOfColors;
        }

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                listOfColors[i] = Color.GREEN;
            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                answer = answer.substring(0, i) + " " + answer.substring(i + 1);
                listOfColors[i] = Color.YELLOW;
            } else {
                listOfColors[i] = Color.RED;
            }
        }
        return listOfColors;
    }
}
