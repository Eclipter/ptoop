package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Line;
import javafx.scene.canvas.GraphicsContext;

public class LineDrawer extends AbstractDrawer {

    public LineDrawer(GraphicsContext graphicsContext) {
        super(graphicsContext);
    }

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Line.class);
    }

    public void drawFigure(Figure figure) {
        Line line = (Line) figure;
        getGraphicsContext().strokeLine(line.getA().getX(), line.getA().getY(), line.getB().getX(), line.getB().getY());
    }
}
