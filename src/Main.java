import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        ArrayList<Character> answer = new ArrayList<Character>();
        answer.add('c');
        answer.add('h');
        answer.add('a');
        answer.add('r');
        ArrayList<Character> guess = new ArrayList<Character>();
        guess.add('a');
        guess.add('a');
        guess.add('a');
        guess.add('a');
        ArrayList<Color> colors = guessWordColors(answer, guess);
        System.out.println(colors);

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