package by.bsuir.ptoop.controller.editor;

import by.bsuir.ptoop.controller.dialog.AbstractDialog;
import by.bsuir.ptoop.controller.dialog.EllipseDialog;
import by.bsuir.ptoop.model.Ellipse;
import by.bsuir.ptoop.model.Figure;

public class EllipseEditor extends AbstractEditor {

    @Override
    public boolean supports(Figure figure) {
        return figure.getClass().isAssignableFrom(Ellipse.class);
    }

    @Override
    public AbstractDialog<?> newDialog() {
        return new EllipseDialog();
    }

    @Override
    public AbstractDialog<Figure> newDialog(Figure figure) {
        return new EllipseDialog(figure);
    }
}
