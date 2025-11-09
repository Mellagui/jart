import GeometricalShapes.*;

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);

        // Draw some points
        Point point1 = new Point(50, 100);
        point1.draw(image);

        Point point2 = new Point(300, 400);
        point2.draw(image);

        Point point3 = new Point(500, 600);
        point3.draw(image);

        // Draw a square with 45-degree rotation
        Square square1 = new Square(new Point(200, 200), 100, 45);
        square1.draw(image);

        // Draw a square with no rotation
        Square square2 = new Square(new Point(500, 200), 80, 0);
        square2.draw(image);

        // Draw a pentagon pointing upward (default)
        Pentagon pentagon1 = new Pentagon(new Point(200, 500), 80);
        pentagon1.draw(image);

        // Draw a pentagon with 36-degree rotation
        Pentagon pentagon2 = new Pentagon(new Point(500, 500), 90, 36);
        pentagon2.draw(image);

        // Draw random squares with random rotations
        for (int i = 0; i < 10; i++) {
            Square randomSquare = Square.random(image.getWidth(), image.getHeight());
            randomSquare.draw(image);
        }

        // Draw random pentagons with random rotations
        for (int i = 0; i < 10; i++) {
            Pentagon randomPentagon = Pentagon.random(image.getWidth(), image.getHeight());
            randomPentagon.draw(image);
        }

        // Uncomment these to test other shapes
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