import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Frame {
    private int row;
    private int col;
    private char[][] spaces;

    private String[][] colors;

    public Frame(int row, int col,ArrayList guessWordColors) {
        this.row=row;
        this.col=col;
        spaces=new char[row][col];
        colors=new String[row][col];
        for (int i=0; i<colors.length; i++) {
            for (int j=0; j<colors[0].length; j++) {
                colors[i][j]="gray";
            }
        }

    }
    //override sortWords for the other modes with different length words
    private ArrayList<String> sortWords() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthFive.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }
    //override generate word for the other modes with different length words
    private String generateWord() throws FileNotFoundException {
        ArrayList<String> wordsList=sortWords();
        return wordsList.get((int)(Math.random()*wordsList.size())+1);
    }

}
