package fr.parisnanterre.miage.poa.td0.shapes.implem;

public class Rectangle extends Shape2D {

    private double length;
    private double width;

    public Rectangle(Point2D refPoint, double length, double width) {
        super(refPoint);
        this.length=length;
        this.width=width;
    }

    @Override
    public double perimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public double surface() {
        return this.width * this.length;
    }

    @Override
    public void translate(double dx, double dy) {

    }
}
