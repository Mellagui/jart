package GeometricalShapes;

import java.awt.Color;

public class Cube implements Drawable {
    private final Point center;
    private final int size;
    private final double rotationX;
    private final double rotationY;
    private final double rotationZ;
    private final Color color;

    public Cube(Point center, int size, double rotationX, double rotationY, double rotationZ) {
        this.center = center;
        this.size = size;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
        this.color = getColor();
    }

    public Cube(Point center, int size) {
        this(center, size, 30, 45, 0);
    }

    @Override
    public void draw(Displayable displayable) {
        int maxWidth = 10000;
        int maxHeight = 10000;
        if (displayable instanceof Image) {
            maxWidth = ((Image) displayable).getWidth();
            maxHeight = ((Image) displayable).getHeight();
        }

        Point[] vertices = calculateVertices();

        drawEdge(displayable, vertices[0], vertices[1], maxWidth, maxHeight);
        drawEdge(displayable, vertices[1], vertices[2], maxWidth, maxHeight);
        drawEdge(displayable, vertices[2], vertices[3], maxWidth, maxHeight);
        drawEdge(displayable, vertices[3], vertices[0], maxWidth, maxHeight);

        drawEdge(displayable, vertices[4], vertices[5], maxWidth, maxHeight);
        drawEdge(displayable, vertices[5], vertices[6], maxWidth, maxHeight);
        drawEdge(displayable, vertices[6], vertices[7], maxWidth, maxHeight);
        drawEdge(displayable, vertices[7], vertices[4], maxWidth, maxHeight);

        drawEdge(displayable, vertices[0], vertices[4], maxWidth, maxHeight);
        drawEdge(displayable, vertices[1], vertices[5], maxWidth, maxHeight);
        drawEdge(displayable, vertices[2], vertices[6], maxWidth, maxHeight);
        drawEdge(displayable, vertices[3], vertices[7], maxWidth, maxHeight);
    }

    private Point[] calculateVertices() {
        Point[] vertices = new Point[8];
        double half = size / 2.0;

        double[][] cubePoints = {
            {-half, -half, -half},
            {half, -half, -half},
            {half, half, -half},
            {-half, half, -half},
            {-half, -half, half},
            {half, -half, half},
            {half, half, half},
            {-half, half, half}
        };

        double radX = Math.toRadians(rotationX);
        double radY = Math.toRadians(rotationY);
        double radZ = Math.toRadians(rotationZ);

        double cosX = Math.cos(radX);
        double sinX = Math.sin(radX);
        double cosY = Math.cos(radY);
        double sinY = Math.sin(radY);
        double cosZ = Math.cos(radZ);
        double sinZ = Math.sin(radZ);

        for (int i = 0; i < 8; i++) {
            double x = cubePoints[i][0];
            double y = cubePoints[i][1];
            double z = cubePoints[i][2];

            double tempY = y * cosX - z * sinX;
            double tempZ = y * sinX + z * cosX;
            y = tempY;
            z = tempZ;

            double tempX = x * cosY + z * sinY;
            tempZ = -x * sinY + z * cosY;
            x = tempX;
            z = tempZ;

            tempX = x * cosZ - y * sinZ;
            tempY = x * sinZ + y * cosZ;
            x = tempX;
            y = tempY;

            int screenX = (int) Math.round(center.getX() + x);
            int screenY = (int) Math.round(center.getY() + y);

            vertices[i] = new Point(screenX, screenY);
        }

        return vertices;
    }

    private void drawEdge(Displayable displayable, Point p1, Point p2, int maxWidth, int maxHeight) {
        int x1 = p1.getX(), y1 = p1.getY();
        int x2 = p2.getX(), y2 = p2.getY();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (x1 >= 0 && y1 >= 0 && x1 < maxWidth && y1 < maxHeight) {
                displayable.display(x1, y1, this.color);
            }

            if (x1 == x2 && y1 == y2) break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    public static Cube random(int maxWidth, int maxHeight) {
        java.util.Random rand = new java.util.Random();

        int x = rand.nextInt(maxWidth);
        int y = rand.nextInt(maxHeight);
        int size = 30 + rand.nextInt(100);
        double rotX = rand.nextDouble() * 360;
        double rotY = rand.nextDouble() * 360;
        double rotZ = rand.nextDouble() * 360;

        return new Cube(new Point(x, y), size, rotX, rotY, rotZ);
    }

    public Point getCenter() {
        return center;
    }

    public int getSize() {
        return size;
    }

    public double getRotationX() {
        return rotationX;
    }

    public double getRotationY() {
        return rotationY;
    }

    public double getRotationZ() {
        return rotationZ;
    }
}
