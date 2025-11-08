package GeometricalShapes;

public class Image implements Displayable {
    int width, height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }

    @Override
    public void display(int x, int y, Color color) {

    }

    @Override
    public void save(String string) {
        
    }
}
