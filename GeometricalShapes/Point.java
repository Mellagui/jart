package GeometricalShapes;

import java.awt.Color;

public class Point implements Drawable {
    int x, y;
    Color color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = getColor();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override
    public void draw(Displayable displayable) {
        displayable.display(this.x, this.y, this.color);
    }
}
