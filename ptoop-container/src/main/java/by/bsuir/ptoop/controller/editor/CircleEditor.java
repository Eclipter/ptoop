package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.CircleDialog;
import by.bsuir.ptoop.model.Circle;
import by.bsuir.ptoop.model.Figure;

public class CircleEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Circle.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new CircleDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new CircleDialog(figure);
    }
}
