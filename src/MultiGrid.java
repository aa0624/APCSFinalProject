import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class MultiGrid{
    private final int numofgrids;
    private JFrame frame;
    private JPanel bottomtextpanel;
    public MultiGrid(int numofgrids) throws FileNotFoundException {
        this.numofgrids = numofgrids;
        Grid[] gameGrids = new Grid[numofgrids];
        JFrame frame = new JFrame("MultiWordle");
        for(int i = 0; i < numofgrids; i++){
            gameGrids[i] = new Grid(6 * numofgrids,Main.generateWord());
            frame.add(gameGrids[i].getPanelNoFrame());
        }
        bottomtextpanel = new JPanel();
        bottomtextpanel.setLayout(new BorderLayout());
        frame.add(bottomtextpanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}

