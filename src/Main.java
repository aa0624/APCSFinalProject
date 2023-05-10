import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("fahdljfashdfasfd!");
    }

    public static ArrayList<Color> guessWordColors (ArrayList<Character> answer, ArrayList<Character> guess){
        ArrayList<Color> listOfColors = new ArrayList<Color>(answer.size());

        if (guess.size() == answer.size() && answer.size() > 0){
            for (int i = 0; i < answer.size(); i++) {
                for (int j = 0; j < guess.size(); j++) {
                    if (i == j && answer.get(i) == guess.get(j)) {
                        listOfColors.set(i, Color.GREEN);
                    } else if (answer.contains(guess.get(j))) {
                        listOfColors.set(j, Color.YELLOW);
                    } else {
                        listOfColors.set(j, Color.GRAY);
                    }
                }
            }
        }
        return listOfColors;
    }


}