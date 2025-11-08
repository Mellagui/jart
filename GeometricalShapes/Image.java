package GeometricalShapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Image implements Displayable {
    private final BufferedImage image;
    int width, height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        System.out.println(image);
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }

    public void display(int x, int y, Color color) {
        image.setRGB(x, y, color.getRGB());
    }

    @Override
    public void save(String filename) {
        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
