package GeometricalShapes;

public class Line implements Drawable {
    Point x, y;
    Color color;

    public Line(Point x, Point y) {
        this.x = x;
        this.y = y;
        this.color = new Color();
    }

    public Line(Point x, Point y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Displayable displayable) {
        
    }

    @Override
    public Color getColor() { return this.color; }
}
