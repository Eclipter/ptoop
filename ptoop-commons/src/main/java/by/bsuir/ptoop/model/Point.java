package by.bsuir.ptoop.model;

public class Point extends Figure
{
    private static final long serialVersionUID = 4758551746499542532L;

    private int x;
    private int y;

    public Point(int x, int y)
    {

        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
