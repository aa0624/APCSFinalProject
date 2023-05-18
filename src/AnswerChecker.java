import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerChecker {

    private final Color customYellow;
    private final Color customGreen;
    private final Color customGrey;


    private JPanel bottomtextpanel, finalPanel;

    private int row, currentRow;


    public AnswerChecker(int row, Grid[] grids) {
        this.row = row;

        customGreen = new Color(108, 169, 101);
        customYellow = new Color(200, 182, 83);
        customGrey = new Color(120, 124, 127);

        bottomtextpanel = new JPanel();
        bottomtextpanel.setLayout(new BorderLayout());

        finalPanel = new JPanel();

        JTextField answerField = new JTextField("", 10);
        bottomtextpanel.add(answerField, BorderLayout.WEST);

        JButton enterbutton = new JButton("Enter");
        bottomtextpanel.add(enterbutton, BorderLayout.EAST);
        // action button function specifically for the enter button
        enterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Grid g : grids) {
                    if (answerField.getText().length() == g.getAnswer().length()) {

                        compareToAnswer(g.getAnswer(), answerField.getText().toUpperCase(), g);
                    }
                }
                currentRow++;
            }
        });
    }

    // compares word to answer and updates both 2d arrays with calls to other functions
    //get answer anbd final text
    public void compareToAnswer(String answer, String guess, Grid g) {
        int greencount = 0;
        Color[] listOfColors = new Color[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                answer = answer.substring(0, i) + " " + answer.substring(i+1);
                listOfColors[i] = Color.GREEN;
                greencount++;
            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                answer = answer.substring(0, i) + " " + answer.substring(i+1);
                listOfColors[i] = Color.YELLOW;
            } else {
                listOfColors[i] = Color.RED;
            }
        }
        if (greencount == answer.length()) {
            g.setFinalText("you win");
            congratulate(g);
        } else if (currentRow == row - 1) {
            congratulate(g);
        }
        updateColorList(listOfColors, g);
        updateWordShown(guess, g);
        updateLetters(guess, g);
    }

    private void congratulate(Grid g) {
        finalPanel.add(new JLabel(g.getFinalText()));
        g.setAllWordGrid(finalPanel);
    }

    public JPanel getFinalPanel() {
        return finalPanel;
    }

    public JPanel getBottomtextpanel() {
        return bottomtextpanel;
    }

    //takes a list of colors and adds it to the next row available in the 2d color array
    private void updateColorList(Color[] colorlist, Grid g) {
        for (int i = 0; i < g.getCol(); i++) {
            g.getColors()[currentRow][i] = colorlist[i];
        }
    }

    private void updateLetters(String guess, Grid g) {
        for (int i = 0; i < g.getCol(); i++) {
            g.getLetters()[currentRow][i].setText(String.valueOf(guess.charAt(i)));
            g.getLetters()[currentRow][i].setForeground(g.getColors()[currentRow][i]);
        }
    }

    // updates the letters in the 2d Array
    private void updateWordShown(String guess, Grid g) {
        for (int i = 0; i < g.getSpaces()[0].length; i++) {
            g.getSpaces()[currentRow][i] = guess.charAt(i);
        }
    }
}


