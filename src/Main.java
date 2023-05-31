import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MenuScreen m = new MenuScreen();
    }

//helper
    //override generate word for the other modes with different length words
    public static String generateWordFive() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWordsFive();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWordsFive() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthFive.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
    public static String generateWordFour() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWordsFour();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWordsFour() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthFour.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
    public static String generateWordThree() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWordsThree();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWordsThree() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthThree.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
    public static String generateWordSix() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWordsSix();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWordsSix() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthSix.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
    public static String generateWordSeven() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWordsSeven();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWordsSeven() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthSeven.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
    public static String generateWordEight() throws FileNotFoundException {
        ArrayList<String> wordsList = sortWordsEight();
        return wordsList.get(new Random().nextInt(wordsList.size() - 1));
    }

    //override sortWords for the other modes with different length words
    public static ArrayList<String> sortWordsEight() throws FileNotFoundException {
        Scanner s = new Scanner(new File("data/wordsLengthEight.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (s.hasNext()) {
            list.add(s.next());
        }

        s.close();
        return list;
    }
}