package by.bsuir.ptoop.controller;

import by.bsuir.ptoop.model.Circle;
import by.bsuir.ptoop.model.Figure;

public class CircleDrawer extends AbstractDrawer {

    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Circle.class);
    }

    public void drawFigure(Figure figure) {

    }
}
