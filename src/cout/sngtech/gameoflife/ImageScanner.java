package cout.sngtech.gameoflife;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageScanner {

    BufferedImage image;
    int width, height;

    int[] pixels;

    public ImageScanner(String path) {
        File file = new File(path);
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public void setupGrid(Grid grid) {
        for(int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                System.out.println(image.getRGB(x, y));
                if(image.getRGB(x, y) == 0xFF000000) {
                    grid.grid[y][x] = 1;
                }
            }
        }
    }
}
