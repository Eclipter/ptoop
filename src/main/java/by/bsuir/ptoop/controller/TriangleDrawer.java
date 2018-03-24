package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Triangle;
import javafx.scene.canvas.GraphicsContext;

public class TriangleDrawer extends AbstractDrawer {

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
        xCoords[1] = triangle.getA().getX();
        xCoords[2] = triangle.getA().getX();
        yCoords[0] = triangle.getA().getY();
        yCoords[1] = triangle.getA().getY();
        yCoords[2] = triangle.getA().getY();
        getGraphicsContext().fillPolygon(xCoords, yCoords, 3);
    }
}
