package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;
import javafx.scene.canvas.GraphicsContext;

public class PointDrawer extends AbstractDrawer {

    public PointDrawer() {
    }

    public PointDrawer(GraphicsContext graphicsContext) {
        super(graphicsContext);
    }

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Point.class);
    }

    public void drawFigure(Figure figure) {
        Point point = (Point) figure;
        getGraphicsContext().strokeLine(point.getX(), point.getY(), point.getX(), point.getY());
    }
}
