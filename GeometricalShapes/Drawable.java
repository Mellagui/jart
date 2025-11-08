package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public interface Drawable {
    void draw(Displayable displayable);

    default Color getColor() {
        int rnd = (new Random()).nextInt(256);
        return new Color(rnd, rnd, rnd);
    }
}