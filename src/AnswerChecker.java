import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerChecker {

    private Color customYellow;
    private Color customGreen;
    private Color customGrey;


    private JPanel bottomtextpanel, finalPanel;

    private int row;
    private Grid[] grids;
    private boolean endGame;

    public AnswerChecker(int row, Grid[] grids) {
        this.row = row;
        this.grids=grids;

        customGreen = new Color(108, 169, 101);
        customYellow = new Color(200, 182, 83);
        customGrey = new Color(120, 124, 127);

        bottomtextpanel = new JPanel();
        bottomtextpanel.setLayout(new BorderLayout());

        finalPanel = new JPanel();
        endGame=false;

        JTextField answerField = new JTextField("", 10);
        bottomtextpanel.add(answerField, BorderLayout.WEST);

        JButton enterbutton = new JButton("Enter");
        bottomtextpanel.add(enterbutton, BorderLayout.EAST);
        // action button function specifically for the enter button
        enterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answerField.getText().length() == grids[0].getAnswer().length()) {
                    for (Grid g : grids) {
                        compareToAnswer(g.getAnswer(), answerField.getText().toUpperCase(), g);
                        g.setCurrentRow(g.getCurrentRow()+1);
                    }
                }
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
                answer = answer.substring(0, i) + " " + answer.substring(i + 1);
                listOfColors[i] = customGreen;
                greencount++;
            }
        }
        for (int j = 0; j < answer.length(); j++) {
            if (answer.contains(String.valueOf(guess.charAt(j))) && listOfColors[j] != customGreen) {
                answer = answer.substring(0, j) + " " + answer.substring(j + 1);
                listOfColors[j] = customYellow;
            }
        for (int k = 0; k < answer.length(); k++) {
            if (listOfColors[k] == null) {
                listOfColors[k] = customGrey;
            }
        }

            if (g.getCurrentRow() >= row) {
                congratulate();
            }
            else if (g.getEndGame()!= true){
                updateColorList(listOfColors, g);
                updateWordShown(guess, g);
                updateLetters(guess, g);
            }
            if (greencount == answer.length()) {
                g.setWin(true);
            }
        }
    }

    private void congratulate() {
        boolean allWin=true;
        for (Grid g: grids) {
            if (g.getWin()!=true) {
                allWin=false;
            }
        }
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
            g.getColors()[g.getCurrentRow()][i] = colorlist[i];
        }
    }

    private void updateLetters(String guess, Grid g) {
        for (int i = 0; i < g.getCol(); i++) {
            g.getLetters()[g.getCurrentRow()][i].setText(String.valueOf(guess.charAt(i)));
            g.getLetters()[g.getCurrentRow()][i].setForeground(g.getColors()[g.getCurrentRow()][i]);
        }
    }

    public void setCustomGreen(Color green){
        customGreen = Color.GREEN;
    }
    public void setCustomYellow(Color yellow){
        customYellow = Color.YELLOW;
    }
    public void setCustomGrey(Color gray){
        customGrey = Color.GRAY;
    }

    // updates the letters in the 2d Array
    private void updateWordShown(String guess, Grid g) {
        for (int i = 0; i < g.getSpaces()[0].length; i++) {
            g.getSpaces()[g.getCurrentRow()][i] = guess.charAt(i);
        }
    }
}


