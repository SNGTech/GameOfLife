package cout.sngtech.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main {

    public static Timer timer;

    public static Dimension size;
    public static Grid grid;
    public static ImageScanner imageScanner;

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();

        grid = new Grid(60, 100, 10);
        //imageScanner = new ImageScanner("src/assets/grid.png");
        //imageScanner = new ImageScanner("src/assets/eye.png");
        //imageScanner = new ImageScanner("src/assets/squares.png");
        imageScanner = new ImageScanner("src/assets/simkin_glider_gun.png");
        //imageScanner = new ImageScanner("src/assets/name.png");
        imageScanner.setupGrid(grid);

        timer = new Timer(1, Main::tick);
        timer.start();
    }

    public static void tick(ActionEvent e) {
        GameFrame.getWindow().tick();
        grid.tick();
    }
}
