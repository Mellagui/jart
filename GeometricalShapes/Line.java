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

    public Line random(int width , int height){
        Random random = new Random();
        return new Line(new Point(random.nextInt(width), random.nextInt(height)), new Point(random.nextInt(width), random.nextInt(height)));
    }

    @Override
    public void draw(Displayable displayable) {
        int x0 = p1.x;
        int y0 = p1.y;
        int x1 = p2.x;
        int y1 = p2.y;

        int dx = x1 - x0;
        int dy = y1 - y0;

        // number of steps (at least 1)
        float steps = Math.max(1, Math.max(Math.abs(dx), Math.abs(dy)));

        for (int i = 0; i <= (int) steps; i++) {
            float t = i / steps;
            int xi = (int) Math.floor(x0 + dx * t);
            int yi = (int) Math.floor(y0 + dy * t);
            // Color is immutable; no need to clone
            displayable.display(xi, yi, color);
        }
    }
}
