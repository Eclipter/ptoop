package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.PointDialog;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Point;

public class PointEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Point.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new PointDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new PointDialog(figure);
    }
}
