package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Ellipse;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Rectangle;

public class EllipseDrawer extends AbstractDrawer {

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Ellipse.class);
    }

    public void drawFigure(Figure figure) {

    }
}
