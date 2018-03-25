package by.bsuir.ptoop.model;

public class RoundRectangle extends Figure {

    private static final long serialVersionUID = 369311943010378277L;

    private Point a;
    private int width;
    private int height;
    private int arcWidth;
    private int arcHeight;

    public RoundRectangle(Point a, int width, int height, int arcWidth, int arcHeight) {
        this.a = a;
        this.width = width;
        this.height = height;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
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

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    @Override
    public String toString() {
        return "RoundRectangle{" +
                "a=" + a +
                ", width=" + width +
                ", height=" + height +
                ", arcWidth=" + arcWidth +
                ", arcHeight=" + arcHeight +
                '}';
    }
}
