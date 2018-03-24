package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Ellipse;
import by.bsuir.ptoop.model.Figure;
import javafx.scene.canvas.GraphicsContext;

public class EllipseDrawer extends AbstractDrawer {

    public EllipseDrawer(GraphicsContext graphicsContext) {
        super(graphicsContext);
    }

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Ellipse.class);
    }

    public void drawFigure(Figure figure) {
        Ellipse ellipse = (Ellipse) figure;
        getGraphicsContext().fillOval(ellipse.getO().getX(), ellipse.getO().getY(), ellipse.getWidth(), ellipse.getHeight());
    }
}
