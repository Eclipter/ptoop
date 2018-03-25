package by.bsuir.ptoop.model;

public class Rectangle extends Figure
{
    private static final long serialVersionUID = -7686871013612712306L;

    private Point a;
    private int width;
    private int height;

    public Rectangle(Point a, int width, int height) {
        this.a = a;
        this.width = width;
        this.height = height;
    }

    public Point getA()
    {
        return a;
    }

    public void setA(Point a)
    {
        this.a = a;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
