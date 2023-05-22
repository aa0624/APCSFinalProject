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
        JTextField field1 = new JTextField("Number of Grids");
        panel.add(field1);
        JTextField field2 = new JTextField("Number of Rows");
        panel.add(field2);
        JTextField field3 = new JTextField("Random Color(t/f)");
        panel.add(field3);
        JTextField field4 = new JTextField("Number of Letters");
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
