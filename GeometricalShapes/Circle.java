package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public class Circle implements Drawable {
    private static final int MAX_RADIUS = 40;
    private static final int MIN_RADIUS = 250;
    
    public Point center;
    public int radius;
    public Color color;
    
    public Circle(Point center, int radius) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
        this.color = generateRandomColor();
    }
    
    public static Circle random(int width, int height) {
        Random rand = new Random();
        Point center = Point.random(width, height);
        int radius = rand.nextInt(MIN_RADIUS - MAX_RADIUS) + MAX_RADIUS;
        return new Circle(center, radius);
    }

    @Override
    public void draw(Displayable displayable) {
        // Midpoint Circle Algorithm
        int x = 0;
        int y = this.radius;
        int decisionParam = 1 - this.radius;
        
        while (x <= y) {
            // Place pixels in 8 symmetric positions
            int cx = center.getX();
            int cy = center.getY();
            displayable.display(cx + x, cy + y, color);
            displayable.display(cx - x, cy + y, color);
            displayable.display(cx + x, cy - y, color);
            displayable.display(cx - x, cy - y, color);
            displayable.display(cx + y, cy + x, color);
            displayable.display(cx + y, cy - x, color);
            displayable.display(cx - y, cy + x, color);
            displayable.display(cx - y, cy - x, color);
            
            x++;
            if (decisionParam < 0) {
                decisionParam += 2 * x + 1;
            } else {
                y--;
                decisionParam += 2 * (x - y) + 1;
            }
        }
    }
    
    @Override
    public Color getColor() {
        return color;
    }
    
    private Color generateRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

}