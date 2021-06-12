package cout.sngtech.gameoflife;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    public GameWindow() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;

        //Draw Cells
        Main.grid.fillGrid(g2d);

        //Draw Wire Frame
        Main.grid.drawWireFrame(g2d);
    }

    public void tick() {
        repaint();
    }
}
