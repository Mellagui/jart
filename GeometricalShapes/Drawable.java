package GeometricalShapes;

import java.util.Random;
import java.awt.Color;

public interface Drawable {
    void draw(Displayable displayable);

    default Color getColor() {
        int rnd = (new Random()).nextInt(256);
        return new Color(rnd, rnd, rnd);
    }
}