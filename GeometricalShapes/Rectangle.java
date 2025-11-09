package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public class Rectangle implements Drawable {
    private final Point topLeft;
    private final Point bottomRight;
    private final Color color;

    public Rectangle(Point p1, Point p2) {
        // Normalize coordinates so topLeft is truly at top-left corner
        int minX = Math.min(p1.getX(), p2.getX());
        int minY = Math.min(p1.getY(), p2.getY());
        int maxX = Math.max(p1.getX(), p2.getX());
        int maxY = Math.max(p1.getY(), p2.getY());

        this.topLeft = new Point(minX, minY);
        this.bottomRight = new Point(maxX, maxY);
        this.color = randomColor();
    }

    @Override
    public void draw(Displayable displayable) {
        // int x1 = topLeft.getX();
        // int y1 = topLeft.getY();
        int x2 = bottomRight.getX();
        int y2 = bottomRight.getY();

        Point p1 = new Point(topLeft.getX(), topLeft.getY());
        Point p2 = new Point(bottomRight.getX(), bottomRight.getY());
        Point p3 = new Point(topLeft.getX(), bottomRight.getY());
        Point p4 = new Point(bottomRight.getX(), topLeft.getY());

        // Draw the rectangle using 4 lines
        Line top = new Line(p1, p4, color);
        Line bottom = new Line(p3, p2, color);
        Line left = new Line(p4, p2, color);
        Line right = new Line(p1, p3, color);

        top.draw(displayable);
        bottom.draw(displayable);
        left.draw(displayable);
        right.draw(displayable);
    }

    private Color randomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public Color getColor() {
        return color;
    }
}
