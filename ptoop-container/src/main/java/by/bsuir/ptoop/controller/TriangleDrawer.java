package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Triangle;
import javafx.scene.canvas.GraphicsContext;

public class TriangleDrawer extends AbstractDrawer {

    public TriangleDrawer() {
    }

    public TriangleDrawer(GraphicsContext graphicsContext) {
        super(graphicsContext);
    }

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Triangle.class);
    }

    public void drawFigure(Figure figure) {
        Triangle triangle = (Triangle) figure;
        double[] xCoords = new double[3];
        double[] yCoords = new double[3];
        xCoords[0] = triangle.getA().getX();
        xCoords[1] = triangle.getB().getX();
        xCoords[2] = triangle.getC().getX();
        yCoords[0] = triangle.getA().getY();
        yCoords[1] = triangle.getB().getY();
        yCoords[2] = triangle.getC().getY();
        getGraphicsContext().fillPolygon(xCoords, yCoords, 3);
    }
}
