package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Rectangle;

public class RectangleDrawer extends AbstractDrawer {

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Rectangle.class);
    }

    public void drawFigure(Figure figure) {

    }
}
