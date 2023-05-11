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

    JFrame frame;

    JPanel word1Grid, word2Grid, word3Grid, word4Grid, word5Grid, word6Grid;

    JLabel letter1word1, letter2word1, letter3word1, letter4word1, letter5word1, letter1word2, letter2word2, letter3word2, letter4word2, letter5word2, letter1word3, letter2word3, letter3word3, letter4word3, letter5word3, letter1word4, letter2word4, letter3word4, letter4word4, letter5word4, letter1word5, letter2word5, letter3word5, letter4word5, letter5word5, letter1word6, letter2word6, letter3word6, letter4word6, letter5word6;

    public Frame(){
        //dont need row and col because answer.length is the width and it is always 6 down
        answer = "apple";//temporary until u bozos fix generateWord()
        spaces = new char[answer.length()][6];
        colors = new Color[answer.length()][6];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                colors[i][j] = Color.GRAY;
            }
        }
        // Creates Frame
        frame = new JFrame("Wordle");
        frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Creates panel for word 1 which will hold all the letters
        word1Grid = new JPanel();
        word1Grid.setLayout(new BoxLayout(word1Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 1
        letter1word1 = new JLabel("");
        letter1word1.add(word1Grid);
        letter2word1 = new JLabel("");
        letter2word1.add(word1Grid);
        letter3word1 = new JLabel("");
        letter3word1.add(word1Grid);
        letter4word1 = new JLabel("");
        letter4word1.add(word1Grid);
        letter5word1 = new JLabel("");
        letter5word1.add(word1Grid);
        //adds word one to frame
        word1Grid.add(frame);
        // Creates Panel for word 2
        word2Grid = new JPanel();
        word2Grid.setLayout(new BoxLayout(word2Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 2
        letter1word2 = new JLabel("");
        letter1word2.add(word2Grid);
        letter2word2 = new JLabel("");
        letter2word2.add(word2Grid);
        letter3word2 = new JLabel("");
        letter3word2.add(word2Grid);
        letter4word2 = new JLabel("");
        letter4word2.add(word2Grid);
        letter5word2 = new JLabel("");
        letter5word2.add(word2Grid);
        //adds word two to frame
        word2Grid.add(frame);
        // Creates Panel for word 3
        word3Grid = new JPanel();
        word3Grid.setLayout(new BoxLayout(word3Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 3
        letter1word3 = new JLabel("");
        letter1word3.add(word3Grid);
        letter2word3 = new JLabel("");
        letter2word3.add(word3Grid);
        letter3word3 = new JLabel("");
        letter3word3.add(word3Grid);
        letter4word3 = new JLabel("");
        letter4word3.add(word3Grid);
        letter5word3 = new JLabel("");
        letter5word3.add(word3Grid);
        //adds word three to frame
        word3Grid.add(frame);
        // Creates Panel for word 4
        word4Grid = new JPanel();
        word4Grid.setLayout(new BoxLayout(word4Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 4
        letter1word4 = new JLabel("");
        letter1word4.add(word4Grid);
        letter2word4 = new JLabel("");
        letter2word4.add(word4Grid);
        letter3word4 = new JLabel("");
        letter3word4.add(word4Grid);
        letter4word4 = new JLabel("");
        letter4word4.add(word4Grid);
        letter5word4 = new JLabel("");
        letter5word4.add(word4Grid);
        //adds word four to frame
        word4Grid.add(frame);
        // Creates Panel for word 5
        word5Grid = new JPanel();
        word5Grid.setLayout(new BoxLayout(word5Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 5
        letter1word5 = new JLabel("");
        letter1word5.add(word5Grid);
        letter2word5 = new JLabel("");
        letter2word5.add(word5Grid);
        letter3word5 = new JLabel("");
        letter3word5.add(word5Grid);
        letter4word5 = new JLabel("");
        letter4word5.add(word5Grid);
        letter5word5 = new JLabel("");
        letter5word5.add(word5Grid);
        //adds word five to frame
        word5Grid.add(frame);
        // Creates Panel for word 6
        word6Grid = new JPanel();
        word6Grid.setLayout(new BoxLayout(word6Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 6
        letter1word6 = new JLabel("");
        letter1word6.add(word6Grid);
        letter2word6 = new JLabel("");
        letter2word6.add(word6Grid);
        letter3word6 = new JLabel("");
        letter3word6.add(word6Grid);
        letter4word6 = new JLabel("");
        letter4word6.add(word6Grid);
        letter5word6 = new JLabel("");
        letter5word6.add(word6Grid);
        //adds word six to frame
        word6Grid.add(frame);

        JTextField answerFeild = new JTextField("", 10);

        JButton enterbutton = new JButton("Enter");

        frame.pack();
        frame.setVisible(true);
        // action button function specifically for the enter button
        enterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(answerFeild.getText().length() == answer.length()){
                    compareToAnswer(answer, answerFeild.getText());
                }
            }
        });
    }

    // compares word to answer and updates both 2d arrays with calls to other functions
    public void compareToAnswer(String answer, String guess) {
        Color[] listOfColors = new Color[answer.length()];
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
        updateColorList(listOfColors);
        updateWordShown(guess);
        updateLetters(guess);
    }
    //gets next empty row
    public int getRow() {
        int rownum = 0;
        int whilehelp = 0;
        while (whilehelp == 0) {
            if (colors[0][rownum] != null) {
                rownum++;
            } else {
                whilehelp++;
            }
        } return rownum;
    }
    //takes a list of colors and adds it to the next row availible in the 2d color array
    private void updateColorList(Color[] colorlist){
        for (int i = 0; i < colors.length; i++){
            colors[i][getRow()] = colorlist[i];
        }
    }
    //updates the letters graphic (I couldn't think of a better way to do this so if you do just change it bc this is ugly)
    private void updateLetters(String guess){
        if (getRow() == 0){
            letter1word1.setText(String.valueOf(guess.charAt(0)));
            letter2word1.setText(String.valueOf(guess.charAt(1)));
            letter3word1.setText(String.valueOf(guess.charAt(2)));
            letter4word1.setText(String.valueOf(guess.charAt(3)));
            letter5word1.setText(String.valueOf(guess.charAt(4)));
        } else if (getRow() == 1){
            letter1word2.setText(String.valueOf(guess.charAt(0)));
            letter2word2.setText(String.valueOf(guess.charAt(1)));
            letter3word2.setText(String.valueOf(guess.charAt(2)));
            letter4word2.setText(String.valueOf(guess.charAt(3)));
            letter5word2.setText(String.valueOf(guess.charAt(4)));
        } else if (getRow() == 2){
            letter1word3.setText(String.valueOf(guess.charAt(0)));
            letter2word3.setText(String.valueOf(guess.charAt(1)));
            letter3word3.setText(String.valueOf(guess.charAt(2)));
            letter4word3.setText(String.valueOf(guess.charAt(3)));
            letter5word3.setText(String.valueOf(guess.charAt(4)));
        } else if (getRow() == 3){
            letter1word4.setText(String.valueOf(guess.charAt(0)));
            letter2word4.setText(String.valueOf(guess.charAt(1)));
            letter3word4.setText(String.valueOf(guess.charAt(2)));
            letter4word4.setText(String.valueOf(guess.charAt(3)));
            letter5word4.setText(String.valueOf(guess.charAt(4)));
        } else if (getRow() == 4){
            letter1word5.setText(String.valueOf(guess.charAt(0)));
            letter2word5.setText(String.valueOf(guess.charAt(1)));
            letter3word5.setText(String.valueOf(guess.charAt(2)));
            letter4word5.setText(String.valueOf(guess.charAt(3)));
            letter5word5.setText(String.valueOf(guess.charAt(4)));
        } else {
            letter1word6.setText(String.valueOf(guess.charAt(0)));
            letter2word6.setText(String.valueOf(guess.charAt(1)));
            letter3word6.setText(String.valueOf(guess.charAt(2)));
            letter4word6.setText(String.valueOf(guess.charAt(3)));
            letter5word6.setText(String.valueOf(guess.charAt(4)));
        }
    }
    // updates the letters in the 2d Array
    private void updateWordShown(String guess){
        for (int i = 0; i < spaces.length; i++){
            guess = guess.toUpperCase();
            spaces[i][getRow()] = guess.charAt(i);
        }
    }

    //override sortWords for the other modes with different length words
    private ArrayList<String> sortWords() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthFive.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }

    //override generate word for the other modes with different length words
    private String generateWord() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWords();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }
}
