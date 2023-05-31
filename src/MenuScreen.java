import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MenuScreen {
    private boolean randColor;
    //help
    public MenuScreen (){
        JFrame frame = new JFrame("Wordle Menu");
        JPanel panel = new JPanel();

       // frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        JLabel label1 = new JLabel("Number of Grids");
        panel.add(label1);

        Integer[] gridAmtChoices = {1,2,4,8,16};
        JComboBox<Integer> gridAmtDropdown = new JComboBox<Integer>(gridAmtChoices);
        panel.add(gridAmtDropdown);

        JLabel field3 = new JLabel("Random Color Mode");
        panel.add(field3);
        JButton rcmon = new JButton("On");
        panel.add(rcmon);
        JButton rcmoff = new JButton("Off");
        panel.add(rcmoff);
        JLabel field4 = new JLabel("Number of Letters");
        panel.add(field4);

        Integer[] letterAmtChoices = {3,4,5,6,7,8};
        JComboBox<Integer> letterAmtDropdown = new JComboBox<Integer>(letterAmtChoices);
        panel.add(letterAmtDropdown);

        JButton enter = new JButton("ENTER");
        panel.add(enter);
        frame.add(panel);
        frame.pack();
        randColor = false;
        rcmon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randColor = true;
            }
        });
        rcmoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randColor = false;
            }
        });
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MultiGrid grid = new MultiGrid(gridAmtChoices[gridAmtDropdown.getSelectedIndex()], randColor, letterAmtChoices[letterAmtDropdown.getSelectedIndex()]);
                    frame.dispose();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.setVisible(true);
    }
}
