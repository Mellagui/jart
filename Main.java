import GeometricalShapes.*;

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);

        Point point1 = new Point(50, 100);
        point1.draw(image);

        Point point2 = new Point(300, 400);
        point2.draw(image);

        Point point3 = new Point(500, 600);
        point3.draw(image);

        // Line line = new Line(new Point(50, 50), new Point(300, 300));
        // line.draw(image);

        // Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        // rectangle.draw(image);
        // Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        // triangle.draw(image);

        // for (int i = 0; i < 50; i++) {
        //     Circle circle = Circle.random(image.getWidth(), image.getHeight());
        //     circle.draw(image);
        // }
        
        image.save("image.png");
    }
}