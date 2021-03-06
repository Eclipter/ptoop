package by.bsuir.ptoop.model;

public class Line extends Figure
{
    private static final long serialVersionUID = 6974330710756849249L;

    private Point a;
    private Point b;

    public Line(Point a, Point b)
    {
        this.a = a;
        this.b = b;
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

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
