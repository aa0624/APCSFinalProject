import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("fahdljfashdfasfd!");
        Frame n = new Frame();
    }

    public static Color[] guessWordColors(String answer, String guess) {
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