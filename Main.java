import GeometricalShapes.*;

public class Main {
    public static void main(String[] args) {
        final Image image = new Image(1000, 1000);

        final Point point = new Point(50, 100);
        point.draw(image);

        for (int i = 0; i < 5; i++) {
            final Point randomPoint = Point.random(image.getWidth(), image.getHeight());
            randomPoint.draw(image);
        }

        final Line line = new Line(new Point(50, 50), new Point(300, 300));
        line.draw(image);

        for (int i = 0; i < 3; i++) {
            final Line randomLine = Line.random(image.getWidth(), image.getHeight());
            randomLine.draw(image);
        }

        final Pentagon pentagon1 = new Pentagon(new Point(200, 500), 80);
        pentagon1.draw(image);

        for (int i = 0; i < 3; i++) {
            final Pentagon randomPentagon = Pentagon.random(image.getWidth(), image.getHeight());
            randomPentagon.draw(image);
        }

        final Cube cube1 = new Cube(new Point(750, 200), 100, 30, 45, 0);
        cube1.draw(image);

        for (int i = 0; i < 3; i++) {
            final Cube randomCube = Cube.random(image.getWidth(), image.getHeight());
            randomCube.draw(image);
        }

        final Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);
        final Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            final Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }
        
        image.save("image.png");
    }
}