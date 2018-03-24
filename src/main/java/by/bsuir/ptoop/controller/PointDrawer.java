package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;

public class PointDrawer extends AbstractDrawer {

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Point.class);
    }

    public void drawFigure(Figure figure) {

    }
}
