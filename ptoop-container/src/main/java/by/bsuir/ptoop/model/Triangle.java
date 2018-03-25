package by.bsuir.ptoop.model;

public class Triangle extends Figure
{
    private static final long serialVersionUID = 2355728648139966179L;

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA()
    {
        return a;
    }

    public void setA(Point a)
    {
        this.a = a;
    }

    public Point getB()
    {
        return b;
    }

    public void setB(Point b)
    {
        this.b = b;
    }

    public Point getC()
    {
        return c;
    }

    public void setC(Point c)
    {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
