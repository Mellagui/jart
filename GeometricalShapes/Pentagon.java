package GeometricalShapes;

import java.awt.Color;

public class Pentagon implements Drawable {
    private final Point center;
    private final int radius;
    private final double rotationDegrees;
    private final Color color;

    public Pentagon(Point center, int radius, double rotationDegrees) {
        this.center = center;
        this.radius = radius;
        this.rotationDegrees = rotationDegrees;
        this.color = getColor();
    }

    public Pentagon(Point center, int radius) {
        this(center, radius, -90);
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
        
        for (int i = 0; i < 5; i++) {
            drawLine(displayable, vertices[i], vertices[(i + 1) % 5], maxWidth, maxHeight);
        }
    }

    private Point[] calculateVertices() {
        Point[] vertices = new Point[5];
        double angleStep = 72.0;
        double startAngle = rotationDegrees;
        
        for (int i = 0; i < 5; i++) {
            double angleDegrees = startAngle + (i * angleStep);
            double angleRadians = Math.toRadians(angleDegrees);
            
            int x = (int) Math.round(center.getX() + radius * Math.cos(angleRadians));
            int y = (int) Math.round(center.getY() + radius * Math.sin(angleRadians));
            
            vertices[i] = new Point(x, y);
        }
        
        return vertices;
    }

    private void drawLine(Displayable displayable, Point p1, Point p2, int maxWidth, int maxHeight) {
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

    private void fillPentagon(Displayable displayable, Point[] vertices, int maxWidth, int maxHeight) {
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (Point vertex : vertices) {
            minY = Math.min(minY, vertex.getY());
            maxY = Math.max(maxY, vertex.getY());
        }
        
        minY = Math.max(0, minY);
        maxY = Math.min(maxHeight - 1, maxY);
        
        for (int y = minY; y <= maxY; y++) {
            int[] intersections = new int[5];
            int count = 0;
            
            for (int i = 0; i < 5; i++) {
                Point p1 = vertices[i];
                Point p2 = vertices[(i + 1) % 5];
                
                if ((p1.getY() <= y && p2.getY() > y) || (p2.getY() <= y && p1.getY() > y)) {
                    double t = (y - p1.getY()) / (double) (p2.getY() - p1.getY());
                    int x = (int) Math.round(p1.getX() + t * (p2.getX() - p1.getX()));
                    intersections[count++] = x;
                }
            }
            
            for (int i = 0; i < count - 1; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (intersections[i] > intersections[j]) {
                        int temp = intersections[i];
                        intersections[i] = intersections[j];
                        intersections[j] = temp;
                    }
                }
            }
            
            for (int i = 0; i < count; i += 2) {
                if (i + 1 < count) {
                    for (int x = intersections[i]; x <= intersections[i + 1]; x++) {
                        if (x >= 0 && x < maxWidth && y >= 0 && y < maxHeight) {
                            displayable.display(x, y, this.color);
                        }
                    }
                }
            }
        }
    }

    public static Pentagon random(int maxWidth, int maxHeight) {
        java.util.Random rand = new java.util.Random();
        
        int x = rand.nextInt(maxWidth);
        int y = rand.nextInt(maxHeight);
        int radius = 20 + rand.nextInt(100);
        double rotation = rand.nextDouble() * 360;
        
        return new Pentagon(new Point(x, y), radius, rotation);
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public double getRotationDegrees() {
        return rotationDegrees;
    }
}
