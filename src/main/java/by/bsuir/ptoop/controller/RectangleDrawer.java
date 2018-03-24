package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;

public class RectangleDrawer extends AbstractDrawer {

    public RectangleDrawer(GraphicsContext graphicsContext) {
        super(graphicsContext);
    }

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Rectangle.class);
    }

    public void drawFigure(Figure figure) {
        Rectangle rectangle = (Rectangle) figure;
        getGraphicsContext().fillRect(rectangle.getA().getX(), rectangle.getA().getY(), rectangle.getWidth(), rectangle.getHeight());
    }
}
