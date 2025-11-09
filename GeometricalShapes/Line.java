package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public class Line implements Drawable {
    private final Point p1, p2;
    private final Color color;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = getColor();
    }

    public Line(Point p1, Point p2, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public static Line random(int width , int height) {
        final Random random = new Random();
        return new Line(new Point(random.nextInt(width), random.nextInt(height)), new Point(random.nextInt(width), random.nextInt(height)));
    }

    @Override
    public void draw(Displayable displayable) {
        final int x0 = p1.x;
        final int y0 = p1.y;
        final int x1 = p2.x;
        final int y1 = p2.y;

        final int dx = x1 - x0;
        final int dy = y1 - y0;

        // number of steps (at least 1)
        final float steps = Math.max(1, Math.max(Math.abs(dx), Math.abs(dy)));

        for (int i = 0; i <= (int) steps; i++) {
            final float t = i / steps;
            final int xi = (int) Math.floor(x0 + dx * t);
            final int yi = (int) Math.floor(y0 + dy * t);

            displayable.display(xi, yi, color);
        }
    }
}
