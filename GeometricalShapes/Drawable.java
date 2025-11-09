package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public interface Drawable {
    public abstract void draw(Displayable displayable);

    public default Color getColor() {
        final Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}