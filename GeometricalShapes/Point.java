package GeometricalShapes;

import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {
    public int x, y;
    private final Color color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = getColor();
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Point random(int width , int height){
        Random random = new Random();
        return new Point(random.nextInt(width), random.nextInt(height));
    }

    @Override
    public void draw(Displayable displayable) {
        displayable.display(this.x, this.y, this.color);
    }
}
