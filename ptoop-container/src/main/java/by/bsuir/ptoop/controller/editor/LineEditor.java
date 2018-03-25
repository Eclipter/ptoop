package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.LineDialog;
import by.bsuir.ptoop.model.Figure;
import by.bsuir.ptoop.model.Line;

public class LineEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Line.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new LineDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new LineDialog(figure);
    }
}
