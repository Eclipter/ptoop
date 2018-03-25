package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.RoundRectangleDialog;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.RoundRectangle;

public class RoundRectangleEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(RoundRectangle.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new RoundRectangleDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new RoundRectangleDialog(figure);
    }
}
