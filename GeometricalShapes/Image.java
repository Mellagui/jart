package GeometricalShapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image implements Displayable {
    private final int width, height;
    private final BufferedImage image;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public int getHeight() {
        return this.height;
    }
    public int getWidth() {
        return this.width;
    }

    @Override
    public void display(int x, int y, Color color) {
        this.image.setRGB(x, y, color.getRGB());
    }

    @Override
    public void save(String filename) {
        try {
            ImageIO.write(this.image, "png", new File(filename));
        } catch (IOException err) {
            System.err.println(String.format("ERROR: %s", err));
        }
    }
}