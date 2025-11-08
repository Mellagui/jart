package GeometricalShapes;

public class Color {
    public int R;
    public int G;
    public int B;

    public Color() {
        this.R = Math.getExponent(Math.random() * 255);
        this.G = Math.getExponent(Math.random() * 255);
        this.B = Math.getExponent(Math.random() * 255);
    }

    public static Color getColor() {
        return new Color();
    }
}
