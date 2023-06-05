// Used for hiding the other class
// can call other methods by only one object

// Shape interface
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Facade class
class ShapeMaker {
    private Shape rectangle;
    private Shape circle;
    private Shape square;

    public ShapeMaker() {
        this.rectangle = new Rectangle();
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawSquare() {
        this.square.draw();
    }
    public void startdrawing()
    {    
        drawSquare();
        drawCircle();
        drawRectangle();
    }
}

public class FacadePattern1 
{
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.startdrawing();
    }
}