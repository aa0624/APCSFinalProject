import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerChecker {


        private String answer;
        private char[][] spaces;

        private Color[][] colors;

        private JPanel bottomtextpanel, finalPanel;

        private int row, col, currentRow;

        private String finalText;
        private JLabel[][] letters;


        public AnswerChecker(int row, String answer, char[][] spaces, Color[][] colors){
            this.row = row;
            this.col = answer.length();
            this.answer = answer;
            this.spaces = spaces;
            this.colors = colors;


            bottomtextpanel = new JPanel();
            bottomtextpanel.setLayout(new BorderLayout());

            JTextField answerField = new JTextField("", 10);
            bottomtextpanel.add(answerField, BorderLayout.WEST);

            JButton enterbutton = new JButton("Enter");
            bottomtextpanel.add(enterbutton, BorderLayout.EAST);
            // action button function specifically for the enter button
            enterbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (answerField.getText().length() == answer.length()){
                        compareToAnswer(answer, answerField.getText().toUpperCase());
                    }
                }
            });
        }

        // compares word to answer and updates both 2d arrays with calls to other functions
        public void compareToAnswer(String answer, String guess) {
            int greencount = 0;
            Color[] listOfColors = new Color[answer.length()];
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == guess.charAt(i)) {
                    answer = answer.substring(0, i) + " " + answer.substring(i+1);
                    greencount++;
                    listOfColors[i] = Color.GREEN;
                } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                    answer = answer.substring(0, i) + " " + answer.substring(i+1);
                    listOfColors[i] = Color.YELLOW;
                } else {
                    listOfColors[i] = Color.RED;
                }
            }
            finalText="you lose!";
            if (greencount == answer.length()) {
                finalText = "You win!";
            }
            if (currentRow == row-1) {
                congratulate();
            }
            updateColorList(listOfColors);
            updateWordShown(guess);
            updateLetters(guess);
            currentRow++;
        }

        private void congratulate() {
            finalPanel.add(new JLabel (finalText));
        }

        public JPanel getFinalPanel() {
            return finalPanel;
        }

        //takes a list of colors and adds it to the next row available in the 2d color array
        private void updateColorList(Color[] colorlist){
            for (int i = 0; i < colors[0].length; i++){
                colors[currentRow][i] = colorlist[i];
            }
        }
        private void updateLetters(String guess){
            for (int i = 0; i<col; i++){
                letters[currentRow][i].setText(String.valueOf(guess.charAt(i)));
                letters[currentRow][i].setForeground(colors[currentRow][i]);
            }
        }
        // updates the letters in the 2d Array
        private void updateWordShown(String guess){
            for (int i = 0; i < spaces[0].length; i++){
                spaces[currentRow][i] = guess.charAt(i);
            }
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


