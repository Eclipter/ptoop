package by.bsuir.ptoop.model;

public class Ellipse extends Figure {

    private Point o;
    private int width;
    private int height;

    public Ellipse(Point o, int width, int height) {
        this.o = o;
        this.width = width;
        this.height = height;
    }

    public Point getO() {
        return o;
    }

    public void setO(Point o) {
        this.o = o;
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
}
