package GeometricalShapes;

public class Color {
    public int r;
    public int g;
    public int b;

    public Color() {
        this.r = Math.getExponent(Math.random() * 255);
        this.g = Math.getExponent(Math.random() * 255);
        this.b = Math.getExponent(Math.random() * 255);
    }

    public static Color getColor() {
        return new Color();
    }
}
