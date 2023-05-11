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

public class Frame {

    private String answer;
    private final char[][] spaces;

    private final Color[][] colors;

    JFrame frame;

    JPanel word1Grid;

    JLabel letter1word1, letter2word1, letter3word1, letter4word1, letter5word1;

    public Frame() {
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
        letter1word1 = new JLabel("A");
        letter1word1.add(word1Grid);
        letter2word1 = new JLabel("A");
        letter2word1.add(word1Grid);
        letter3word1 = new JLabel("A");
        letter3word1.add(word1Grid);
        letter4word1 = new JLabel("A");
        letter4word1.add(word1Grid);
        letter5word1 = new JLabel("A");
        letter5word1.add(word1Grid);
        //adds word one to frame
        word1Grid.add(frame);

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
    }
    //takes a list of colors and adds it to the next row availible in the 2d color array
    private void updateColorList(Color[] colorlist){
        int rownum = 0;
        int whilehelp = 0;
        while(whilehelp == 0){
            if (colors[0][rownum] != null){
                rownum++;
            } else {
                whilehelp++;
            }
        }
        for (int i = 0; i < colors.length; i++){
            colors[i][rownum] = colorlist[i];
        }
    }

    private void updateWordShown(String guess){
        int rownum = 0;
        int whilehelp = 0;
        while(whilehelp == 0){
            if (spaces[0][rownum] != 0){
                rownum++;
            } else {
                whilehelp++;
            }
        }
        for (int i = 0; i < spaces.length; i++){
            guess = guess.toUpperCase();
            spaces[i][rownum] = guess.charAt(i);
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
