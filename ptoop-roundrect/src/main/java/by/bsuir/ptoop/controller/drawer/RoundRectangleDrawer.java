package by.bsuir.ptoop.controller.drawer;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.RoundRectangle;

public class RoundRectangleDrawer extends AbstractDrawer {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(RoundRectangle.class);
    }

    @Override
    public void drawFigure(Figure figure) {
        RoundRectangle rectangle = (RoundRectangle) figure;
        getGraphicsContext().fillRoundRect(rectangle.getA().getX(), rectangle.getA().getY(),
                rectangle.getWidth(), rectangle.getHeight(), rectangle.getArcWidth(), rectangle.getArcHeight());
    }
}
