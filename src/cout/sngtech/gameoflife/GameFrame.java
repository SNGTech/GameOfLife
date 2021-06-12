package cout.sngtech.gameoflife;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public static GameWindow window;

    public GameFrame() {
        this.setTitle("Recreation of Conway's Game of Life");
        this.setPreferredSize(new Dimension(900, 600));
        this.setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        window = new GameWindow();
        this.add(window);
        this.pack();
    }

    public static GameWindow getWindow() {
        return window;
    }
}
