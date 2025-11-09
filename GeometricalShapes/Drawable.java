package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public interface Drawable {
    void draw(Displayable displayable);

    default Color getColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}