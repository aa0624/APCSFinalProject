import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Frame {
    private final int row;
    private final int col;
    private final char[][] spaces;

    private final String[][] colors;

    public Frame(int row, int col, Color[] listofcolors) {
        this.row = row;
        this.col = col;
        spaces = new char[row][col];
        colors = new String[row][col];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[0].length; j++) {
                colors[i][j] = "gray";
            }
        }
        // Creates Frame
        JFrame frame = new JFrame("Wordle");
        frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Creates panel for word 1 which will hold all the letters
        JPanel word1Grid = new JPanel();
        word1Grid.setLayout(new BoxLayout(word1Grid, BoxLayout.LINE_AXIS));
        //Creates the letter holders for word 1
        JLabel letter1word1 = new JLabel("A");
        letter1word1.add(word1Grid);
        JLabel letter2word1 = new JLabel("A");
        letter2word1.add(word1Grid);
        JLabel letter3word1 = new JLabel("A");
        letter3word1.add(word1Grid);
        JLabel letter4word1 = new JLabel("A");
        letter4word1.add(word1Grid);
        JLabel letter5word1 = new JLabel("A");
        letter5word1.add(word1Grid);
        //adds word one to frame
        word1Grid.add(frame);

        JTextField answerFeild = new JTextField("", 10);

        frame.pack();
        frame.setVisible(true);

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
