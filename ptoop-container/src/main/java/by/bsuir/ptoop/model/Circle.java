package by.bsuir.ptoop.model;

public class Circle extends Figure
{
    private Point o;
    private int radius;

    public Circle(Point o, int radius)
    {
        this.o = o;
        this.radius = radius;
    }

    public Point getO()
    {
        return o;
    }

    public void setO(Point o)
    {
        this.o = o;
    }

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "o=" + o +
                ", radius=" + radius +
                '}';
    }
}
