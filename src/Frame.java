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

    JPanel word1Grid, word2Grid, word3Grid, word4Grid, word5Grid, word6Grid, bottomtextpanel, allwordGrid;

    JLabel letter1word1, letter2word1, letter3word1, letter4word1, letter5word1, letter1word2, letter2word2, letter3word2, letter4word2, letter5word2, letter1word3, letter2word3, letter3word3, letter4word3, letter5word3, letter1word4, letter2word4, letter3word4, letter4word4, letter5word4, letter1word5, letter2word5, letter3word5, letter4word5, letter5word5, letter1word6, letter2word6, letter3word6, letter4word6, letter5word6;

    public Frame(){
        //dont need row and col because answer.length is the width and it is always 6 down
        answer = "APPLE";//GenerateWord().toUppercase() temporary until u bozos fix generateWord()
        spaces = new char[answer.length()][6];
        colors = new Color[answer.length()][6];
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
        letter1word1 = new JLabel(" ");
        word1Grid.add(letter1word1);
        letter2word1 = new JLabel(" ");
        word1Grid.add(letter2word1);
        letter3word1 = new JLabel(" ");
        word1Grid.add(letter3word1);
        letter4word1 = new JLabel(" ");
        word1Grid.add(letter4word1);
        letter5word1 = new JLabel(" ");
        word1Grid.add(letter5word1);
        //adds word one to frame
        allwordGrid.add(word1Grid);
        // Creates Panel for word 2
        word2Grid = new JPanel();
        word2Grid.setLayout(new BoxLayout(word2Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 2
        letter1word2 = new JLabel(" ");
        word2Grid.add(letter1word2);
        letter2word2 = new JLabel(" ");
        word2Grid.add(letter2word2);
        letter3word2 = new JLabel(" ");
        word2Grid.add(letter3word2);
        letter4word2 = new JLabel(" ");
        word2Grid.add(letter4word2);
        letter5word2 = new JLabel(" ");
        word2Grid.add(letter5word2);
        //adds word two to frame
        allwordGrid.add(word2Grid);
        // Creates Panel for word 3
        word3Grid = new JPanel();
        word3Grid.setLayout(new BoxLayout(word3Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 3
        letter1word3 = new JLabel(" ");
        word3Grid.add(letter1word3);
        letter2word3 = new JLabel(" ");
        word3Grid.add(letter2word3);
        letter3word3 = new JLabel(" ");
        word3Grid.add(letter3word3);
        letter4word3 = new JLabel(" ");
        word3Grid.add(letter4word3);
        letter5word3 = new JLabel(" ");
        word3Grid.add(letter5word3);
        //adds word three to frame
        allwordGrid.add(word3Grid);
        // Creates Panel for word 4
        word4Grid = new JPanel();
        word4Grid.setLayout(new BoxLayout(word4Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 4
        letter1word4 = new JLabel(" ");
        word4Grid.add(letter1word4);
        letter2word4 = new JLabel(" ");
        word4Grid.add(letter2word4);
        letter3word4 = new JLabel(" ");
        word4Grid.add(letter3word4);
        letter4word4 = new JLabel(" ");
        word4Grid.add(letter4word4);
        letter5word4 = new JLabel(" ");
        word4Grid.add(letter5word4);
        //adds word four to frame
        allwordGrid.add(word4Grid);
        // Creates Panel for word 5
        word5Grid = new JPanel();
        word5Grid.setLayout(new BoxLayout(word5Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 5
        letter1word5 = new JLabel(" ");
        word5Grid.add(letter1word5);
        letter2word5 = new JLabel(" ");
        word5Grid.add(letter2word5);
        letter3word5 = new JLabel(" ");
        word5Grid.add(letter3word5);
        letter4word5 = new JLabel(" ");
        word5Grid.add(letter4word5);
        letter5word5 = new JLabel(" ");
        word5Grid.add(letter5word5);
        //adds word five to frame
        allwordGrid.add(word5Grid);
        // Creates Panel for word 6
        word6Grid = new JPanel();
        word6Grid.setLayout(new BoxLayout(word6Grid, BoxLayout.X_AXIS));
        //Creates the letter holders for word 6
        letter1word6 = new JLabel(" ");
        word6Grid.add(letter1word6);
        letter2word6 = new JLabel(" ");
        word6Grid.add(letter2word6);
        letter3word6 = new JLabel(" ");
        word6Grid.add(letter3word6);
        letter4word6 = new JLabel(" ");
        word6Grid.add(letter4word6);
        letter5word6 = new JLabel(" ");
        word6Grid.add(letter5word6);
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
                    System.out.println("test1");
                    compareToAnswer(answer, answerField.getText());
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
        System.out.println("test3");
        updateWordShown(guess);
        System.out.println("test4");
        updateLetters(guess);
        System.out.println("test2");
        frame.repaint();
    }
    //gets next empty row
    public int getRow() {
        int rownum = 0;
        int whilehelp = 0;
        while (whilehelp == 0 || rownum < colors[0].length) {
            if (colors[0][rownum] != null) {
                rownum++;
            } else {
                whilehelp++;
            }
        }
        System.out.println("test0");

        return rownum;
    }
    //takes a list of colors and adds it to the next row available in the 2d color array
    private void updateColorList(Color[] colorlist){
        for (int i = 0; i < colors.length; i++){
            colors[i][getRow()] = colorlist[i];
        }
    }
    //updates the letters graphic (I couldn't think of a better way to do this so if you do just change it bc this is ugly)
    private void updateLetters(String guess){
        if (getRow() == 0){
            letter1word1.setText(String.valueOf(guess.charAt(0)));
            letter1word1.setForeground(colors[0][0]);
            letter2word1.setText(String.valueOf(guess.charAt(1)));
            letter2word1.setForeground(colors[0][1]);
            letter3word1.setText(String.valueOf(guess.charAt(2)));
            letter3word1.setForeground(colors[0][2]);
            letter4word1.setText(String.valueOf(guess.charAt(3)));
            letter4word1.setForeground(colors[0][3]);
            letter5word1.setText(String.valueOf(guess.charAt(4)));
            letter5word1.setForeground(colors[0][4]);
        } else if (getRow() == 1){
            letter1word2.setText(String.valueOf(guess.charAt(0)));
            letter1word2.setForeground(colors[1][0]);
            letter2word2.setText(String.valueOf(guess.charAt(1)));
            letter2word2.setForeground(colors[1][1]);
            letter3word2.setText(String.valueOf(guess.charAt(2)));
            letter3word2.setForeground(colors[1][2]);
            letter4word2.setText(String.valueOf(guess.charAt(3)));
            letter4word2.setForeground(colors[1][3]);
            letter5word2.setText(String.valueOf(guess.charAt(4)));
            letter5word2.setForeground(colors[1][4]);
        } else if (getRow() == 2){
            letter1word3.setText(String.valueOf(guess.charAt(0)));
            letter1word3.setForeground(colors[2][0]);
            letter2word3.setText(String.valueOf(guess.charAt(1)));
            letter2word3.setForeground(colors[2][1]);
            letter3word3.setText(String.valueOf(guess.charAt(2)));
            letter3word3.setForeground(colors[2][2]);
            letter4word3.setText(String.valueOf(guess.charAt(3)));
            letter4word3.setForeground(colors[2][3]);
            letter5word3.setText(String.valueOf(guess.charAt(4)));
            letter5word3.setForeground(colors[2][4]);
        } else if (getRow() == 3){
            letter1word4.setText(String.valueOf(guess.charAt(0)));
            letter1word4.setForeground(colors[3][0]);
            letter2word4.setText(String.valueOf(guess.charAt(1)));
            letter2word4.setForeground(colors[3][1]);
            letter3word4.setText(String.valueOf(guess.charAt(2)));
            letter3word4.setForeground(colors[3][2]);
            letter4word4.setText(String.valueOf(guess.charAt(3)));
            letter4word4.setForeground(colors[3][3]);
            letter5word4.setText(String.valueOf(guess.charAt(4)));
            letter5word4.setForeground(colors[3][4]);
        } else if (getRow() == 4){
            letter1word5.setText(String.valueOf(guess.charAt(0)));
            letter1word5.setForeground(colors[4][0]);
            letter2word5.setText(String.valueOf(guess.charAt(1)));
            letter2word5.setForeground(colors[4][1]);
            letter3word5.setText(String.valueOf(guess.charAt(2)));
            letter3word5.setForeground(colors[4][2]);
            letter4word5.setText(String.valueOf(guess.charAt(3)));
            letter4word5.setForeground(colors[4][3]);
            letter5word5.setText(String.valueOf(guess.charAt(4)));
            letter5word5.setForeground(colors[4][4]);
        } else {
            letter1word6.setText(String.valueOf(guess.charAt(0)));
            letter1word6.setForeground(colors[5][0]);
            letter2word6.setText(String.valueOf(guess.charAt(1)));
            letter2word6.setForeground(colors[5][1]);
            letter3word6.setText(String.valueOf(guess.charAt(2)));
            letter3word6.setForeground(colors[5][2]);
            letter4word6.setText(String.valueOf(guess.charAt(3)));
            letter4word6.setForeground(colors[5][3]);
            letter5word6.setText(String.valueOf(guess.charAt(4)));
            letter5word6.setForeground(colors[5][4]);
        }
    }
    // updates the letters in the 2d Array
    private void updateWordShown(String guess){
        for (int i = 0; i < spaces.length; i++){
            guess = guess.toUpperCase();
            spaces[i][getRow()] = guess.charAt(i);
        }
    }

    //override generate word for the other modes with different length words
    private String generateWord() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWords();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
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
