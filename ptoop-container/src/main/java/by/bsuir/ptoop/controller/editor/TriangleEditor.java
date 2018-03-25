package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.TriangleDialog;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Triangle;

public class TriangleEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Triangle.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new TriangleDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new TriangleDialog(figure);
    }
}
