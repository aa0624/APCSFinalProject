import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Frame{
    private final String answer;
    private char[][] spaces;

    private Color[][] colors;

    private JFrame frame;

    private JPanel word1Grid, word2Grid, word3Grid, word4Grid, word5Grid, word6Grid, bottomtextpanel, allwordGrid;

    private JLabel letter1word1, letter2word1, letter3word1, letter4word1, letter5word1, letter1word2, letter2word2, letter3word2, letter4word2, letter5word2, letter1word3, letter2word3, letter3word3, letter4word3, letter5word3, letter1word4, letter2word4, letter3word4, letter4word4, letter5word4, letter1word5, letter2word5, letter3word5, letter4word5, letter5word5, letter1word6, letter2word6, letter3word6, letter4word6, letter5word6;

    private int row, col,currentRow;

    private JLabel[][] letters;


    public Frame(int row, String answer){
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
        word1Grid = new JPanel();
        word1Grid.setLayout(new BoxLayout(word1Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 1
        for (int i = 0; i<letters.length; i++){
            for (int j = 0; j<letters[0].length; j++){
                letters [i][j] = new JLabel(" ");
            }

        }

        word1Grid.add(letters[0][0]);
        word1Grid.add(letters[0][1]);
        word1Grid.add(letters[0][2]);
        word1Grid.add(letters[0][3]);
        word1Grid.add(letters[0][4]);
        //adds word one to frame
        allwordGrid.add(word1Grid);
        // Creates Panel for word 2
        word2Grid = new JPanel();
        word2Grid.setLayout(new BoxLayout(word2Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 2
        word2Grid.add(letters[1][0]);
        word2Grid.add(letters[1][1]);
        word2Grid.add(letters[1][2]);
        word2Grid.add(letters[1][3]);
        word2Grid.add(letters[1][4]);
        //adds word two to frame
        allwordGrid.add(word2Grid);
        // Creates Panel for word 3
        word3Grid = new JPanel();
        word3Grid.setLayout(new BoxLayout(word3Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 3
        word3Grid.add(letters[2][0]);
        word3Grid.add(letters[2][1]);
        word3Grid.add(letters[2][2]);
        word3Grid.add(letters[2][3]);
        word3Grid.add(letters[2][4]);
        //adds word three to frame
        allwordGrid.add(word3Grid);
        // Creates Panel for word 4
        word4Grid = new JPanel();
        word4Grid.setLayout(new BoxLayout(word4Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 4
        word4Grid.add(letters[3][0]);
        word4Grid.add(letters[3][1]);
        word4Grid.add(letters[3][2]);
        word4Grid.add(letters[3][3]);
        word4Grid.add(letters[3][4]);
        //adds word four to frame
        allwordGrid.add(word4Grid);
        // Creates Panel for word 5
        word5Grid = new JPanel();
        word5Grid.setLayout(new BoxLayout(word5Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 5
        word5Grid.add(letters[4][0]);
        word5Grid.add(letters[4][1]);
        word5Grid.add(letters[4][2]);
        word5Grid.add(letters[4][3]);
        word5Grid.add(letters[4][4]);
        //adds word five to frame
        allwordGrid.add(word5Grid);
        // Creates Panel for word 6
        word6Grid = new JPanel();
        word6Grid.setLayout(new BoxLayout(word6Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 6
        word6Grid.add(letters[5][0]);
        word6Grid.add(letters[5][1]);
        word6Grid.add(letters[5][2]);
        word6Grid.add(letters[5][3]);
        word6Grid.add(letters[5][4]);
        //adds word six to frame
        allwordGrid.add(word6Grid);

        frame.add(allwordGrid, BorderLayout.NORTH);

        bottomtextpanel = new JPanel();
        bottomtextpanel.setLayout(new BorderLayout());
        frame.add(bottomtextpanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField("", 10);
        bottomtextpanel.add(answerField, BorderLayout.WEST);

        JButton enterbutton = new JButton("Enter");
        bottomtextpanel.add(enterbutton, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
        // action button function specifically for the enter button
        enterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (answerField.getText().length() == answer.length()){
                    compareToAnswer(answer, answerField.getText().toUpperCase());
                }
            }
        });
    }

    // compares word to answer and updates both 2d arrays with calls to other functions
    public void compareToAnswer(String answer, String guess) {
        Color[] listOfColors = new Color[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                answer = answer.substring(0, i) + " " + answer.substring(i+1);
                listOfColors[i] = Color.GREEN;
            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                answer = answer.substring(0, i) + " " + answer.substring(i+1);
                listOfColors[i] = Color.YELLOW;
            } else {
                listOfColors[i] = Color.RED;
            }
        }
        updateColorList(listOfColors);
        updateWordShown(guess);
        updateLetters(guess);
        currentRow++;
        frame.repaint();
    }

    //takes a list of colors and adds it to the next row available in the 2d color array
    private void updateColorList(Color[] colorlist){
        for (int i = 0; i < colors[0].length; i++){
            colors[currentRow][i] = colorlist[i];
        }
    }
    //updates the letters graphic (I couldn't think of a better way to do this so if you do just change it bc this is ugly)
    private void updateLetters(String guess){
        for (int i = 0; i<col; i++){
            letters[currentRow][i].setText(String.valueOf(guess.charAt(i)));
            letters[currentRow][i].setForeground(colors[currentRow][i]);
        }
    }
    // updates the letters in the 2d Array
    private void updateWordShown(String guess){
        for (int i = 0; i < spaces[0].length; i++){
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
                    answer = answer.substring(0, i) + " " + answer.substring(i+1);
                    listOfColors[i] = Color.YELLOW;
                } else {
                    listOfColors[i] = Color.RED;
                }
            }
            return listOfColors;
        }
}
