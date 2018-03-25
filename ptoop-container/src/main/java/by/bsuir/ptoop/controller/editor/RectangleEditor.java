package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.RectangleDialog;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Rectangle;

public class RectangleEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Rectangle.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new RectangleDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new RectangleDialog(figure);
    }
}
