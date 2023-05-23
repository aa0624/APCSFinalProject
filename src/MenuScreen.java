import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MenuScreen {

    public MenuScreen (){
        JFrame frame = new JFrame("Wordle Menu");
        JPanel panel = new JPanel();

       // frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        JLabel field1 = new JLabel("Number of Grids");
        panel.add(field1);
        JButton nog1 = new JButton("1");
        panel.add(nog1);
        JButton nog2 = new JButton("2");
        panel.add(nog2);
        JButton nog3 = new JButton("3");
        panel.add(nog3);
        JButton nog4 = new JButton("4");
        panel.add(nog4);
        JLabel field2 = new JLabel("Number of Rows");
        panel.add(field2);
        JButton nor5 = new JButton("5");
        panel.add(nor5);
        JButton nor6 = new JButton("6");
        panel.add(nor6);
        JButton nor7 = new JButton("7");
        panel.add(nor7);
        JButton nor8 = new JButton("8");
        panel.add(nor8);
        JLabel field3 = new JLabel("Random Color Mode");
        panel.add(field3);
        JButton rcmon = new JButton("On");
        panel.add(rcmon);
        JButton rcmoff = new JButton("Off");
        panel.add(rcmoff);
        JLabel field4 = new JLabel("Number of Letters");
        panel.add(field4);
        JButton enter = new JButton("ENTER");
        panel.add(enter);
        frame.add(panel);
        frame.pack();
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean b = false;
                    if (field3.getText().equals("t")){
                        b = true;
                    }
                    MultiGrid grid = new MultiGrid(Integer.parseInt(field1.getText()), Integer.parseInt(field2.getText()), b, Integer.parseInt(field4.getText()));
                    frame.dispose();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.setVisible(true);
    }
}
