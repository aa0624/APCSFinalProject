import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Frame n = new Frame(6,generateWord());
        //Frame n = new Frame(6,"APPLE");
        MultiGrid n = new MultiGrid( 4);
    }


    //override generate word for the other modes with different length words
    public static String generateWord() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWords();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWords() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthFive.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
}