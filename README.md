# 🎨 Jart

## 🧭 Overview

The purpose of this exercise is to **create an image similar to the example below:**

![example](https://learn.zone01oujda.ma/api/content/root/01-edu_module/content/jart/example.png)

You’ll implement a small graphics library that can draw geometric shapes in Java.

---

## 🧩 Instructions

To get started:

1. Copy the code from the [Usage](#usage) section into your `Main.java`.
2. Create the necessary interfaces and classes inside a package named `geometrical_shapes`.

---

## Run project 
```bash
$ javac Main.java GeometricalShapes/*.java -d build
$ java -cp  build Main
```

## 🧱 Required Interfaces

### 🖍️ `Drawable`
Defines drawable shapes.

```java
interface Drawable {
    void draw(Displayable displayable);
    Color getColor();
}
```

### 💾 `Displayable`
Defines what can be displayed and saved.

```java
interface Displayable {
    void display(int x, int y, Color color);
    void save(String string);
}
```

Implement these interfaces according to how they’re used in `Main.java`.

---

## 🔶 Shapes to Implement

You’ll define classes for the following geometric shapes.  
Each class should have a constructor as described below:

| Shape | Constructor Parameters | Description |
|--------|------------------------|-------------|
| **Point** | `int x, int y` | Creates a new point from two integers. |
| **Line** | `Point p1, Point p2` | Creates a line between two points. |
| **Triangle** | `Point p1, Point p2, Point p3` | Creates a triangle from three points. |
| **Rectangle** | `Point p1, Point p2` | Creates a rectangle defined by two corner points. |
| **Circle** | `Point center, int radius` | Creates a circle with a center and a radius. |

---

## 🎲 Random Generation

You must implement a `random` method for the following classes:

- `Point`
- `Line`
- `Circle`

💡 **Hint:**  
The method signatures can be derived from the example in `Main.java`.  
For instance:

```java
Circle circle = Circle.random(image.getWidth(), image.getHeight());
```

---

## 🧠 Bonus Challenges

For extra credit, try adding support for these shapes:

- ⭐ **Pentagon**
- 🧊 **Cube**

Each should implement the necessary interfaces and logic to be drawn and displayed.

---

## 💻 Usage

Here’s the example `Main.java` provided:

```java
interface Displayable {
    void display(int x, int y, Color color);
    void save(String string);
}

interface Drawable {
    void draw(Displayable displayable);
    Color getColor();
}

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);
        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }
        image.save("image.png");
    }
}
```

---

## 📚 Notions

Learn more about Java AWT here:  
👉 [java.awt Documentation](https://www.javatpoint.com/java-awt)

