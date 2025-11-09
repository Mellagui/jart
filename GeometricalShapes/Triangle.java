package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public class Triangle implements Drawable {
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Color color;

    // Constructor: takes 3 vertices
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = randomColor();
    }

    @Override
    public void draw(Displayable displayable) {
        // Draw the three sides of the triangle
        Line side1 = new Line(p1, p2, color);
        Line side2 = new Line(p2, p3, color);
        Line side3 = new Line(p3, p1, color);

        side1.draw(displayable);
        side2.draw(displayable);
        side3.draw(displayable);
    }

    // Generate a random color
    private Color randomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public Color getColor() {
        return color;
    }
}
