package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Line;

public class LineDrawer extends AbstractDrawer {

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Line.class);
    }

    public void drawFigure(Figure figure) {

    }
}
