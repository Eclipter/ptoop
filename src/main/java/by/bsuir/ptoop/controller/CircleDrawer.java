package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Circle;
import by.bsuir.ptoop.model.Figure;
import javafx.scene.canvas.GraphicsContext;

public class CircleDrawer extends AbstractDrawer {

    public CircleDrawer(GraphicsContext graphicsContext) {
        super(graphicsContext);
    }

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Circle.class);
    }

    public void drawFigure(Figure figure) {
        Circle circle = (Circle) figure;
        getGraphicsContext().fillOval(circle.getO().getX(), circle.getO().getY(), circle.getRadius(), circle.getRadius());
    }
}
